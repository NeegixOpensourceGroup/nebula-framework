package com.neegix.template.handler;

import com.neegix.template.TemplateTable;
import com.neegix.template.strategy.TemplateFileModelStrategy;
import com.neegix.utils.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.maven.plugin.logging.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Map;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public abstract class AbstractTemplateFileGenerator implements TemplateFileModelStrategy {

    private final String outputBaseDir;
    private final Scanner scanner = new Scanner(System.in);
    private boolean allOverwrite = false;  // 全部覆盖生成标记
    private boolean allSkip = false;       // 全部跳过生成标记

    public AbstractTemplateFileGenerator(String outputBaseDir) {
        this.outputBaseDir = outputBaseDir;
    }

    @Override
    public void generate(TemplateTable templateTable, Log log) {
        log.info("当前工作目录: " + System.getProperty("user.dir"));
        Path templateDirPath = getTemplateDirPath();
        log.info("模板位置: " + templateDirPath);

        URL resourceUrl = getClass().getResource(templateDirPath.toString());
        if (resourceUrl == null) {
            log.error("模板不存在: " + templateDirPath);
            return;
        }

        Map<String, Object> dataModel = getDataModel(templateTable);
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setClassForTemplateLoading(getClass(), templateDirPath.toString());
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

        Path outputDir = Paths.get(outputBaseDir).toAbsolutePath();
        Path businessDir = outputDir.resolve(templateTable.getPackageName().replace(".", "/"))
                .resolve(StringUtils.lowerCaseFirstLetter(templateTable.getJavaTableName()));

        if (Files.exists(businessDir)) {
            log.info("目标根目录已存在: " + businessDir);
            System.out.print("是否继续生成？输入Y继续，输入N跳过所有已存在文件：");
            String choice = scanner.nextLine().trim().toUpperCase();
            if ("N".equals(choice)) {
                allSkip = true;
                log.info("已选择跳过所有已存在文件");
            }
        }

        try {
            Files.createDirectories(outputDir);
            if ("jar".equals(resourceUrl.getProtocol())) {
                try (JarFile jarFile = ((JarURLConnection) resourceUrl.openConnection()).getJarFile()) {
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry entry = entries.nextElement();
                        String entryName = "/" + entry.getName();
                        if (entryName.startsWith(templateDirPath.toString()) && (entryName.endsWith(".java.ftl") || entryName.endsWith(".xml.ftl"))) {
                            processTemplateEntry(log, configuration, dataModel, outputDir, templateTable, entryName, entry.getName());
                        }
                    }
                } catch (IOException e) {
                    log.error("异常信息: " + resourceUrl, e);
                }
            } else {
                try (Stream<Path> stream = Files.walk(Paths.get(resourceUrl.toURI()))) {
                    stream.filter(path -> path.toString().endsWith(".java.ftl") || path.toString().endsWith(".xml.ftl"))
                            .forEach(ftlPath -> processTemplateFile(log, configuration, dataModel, outputDir, templateTable, templateDirPath, ftlPath));
                } catch (IOException | URISyntaxException e) {
                    log.error("Error walking file system: " + resourceUrl, e);
                }
            }
        } catch (IOException e) {
            log.error("Error writing output: ", e);
        }
    }

    private void processTemplateEntry(Log log, Configuration configuration, Map<String, Object> dataModel, Path outputDir, TemplateTable templateTable, String entryName, String jarEntryName) {
        try {
            String relativePath = entryName.substring(getTemplateDirPath().toString().length()).replaceFirst("^/+", "");
            Template template = configuration.getTemplate(relativePath);
            Path outputPath = determineOutputPath(outputDir, relativePath, templateTable.getJavaTableName(), templateTable.getPackageName());

            handleFileGeneration(log, dataModel, template, outputPath);
        } catch (IOException | TemplateException e) {
            log.error("异常信息: " + jarEntryName, e);
        }
    }

    private void processTemplateFile(Log log, Configuration configuration, Map<String, Object> dataModel, Path outputDir, TemplateTable templateTable, Path templateDirPath, Path ftlPath) {
        try {
            String relativePath = templateDirPath.relativize(ftlPath).toString().replace(File.separatorChar, '/');
            Template template = configuration.getTemplate(relativePath);
            Path outputPath = determineOutputPath(outputDir, relativePath, templateTable.getJavaTableName(), templateTable.getPackageName());

            handleFileGeneration(log, dataModel, template, outputPath);
        } catch (IOException | TemplateException e) {
            log.error("Error processing template: " + ftlPath, e);
        }
    }

    private void handleFileGeneration(Log log, Map<String, Object> dataModel, Template template, Path outputPath) throws IOException, TemplateException {
        if (Files.exists(outputPath)) {
            if (allOverwrite) {
                log.info("全部覆盖模式，覆盖文件: " + outputPath);
            } else if (allSkip) {
                log.info("跳过所有已存在文件模式，跳过文件: " + outputPath);
                return;
            } else {
                System.out.print("文件已存在: " + outputPath + "\n1. 覆盖生成\n2. 跳过\n3. 全部覆盖\n4. 跳过所有已存在文件\n请输入选项: ");
                String fileChoice = scanner.nextLine().trim();
                switch (fileChoice) {
                    case "1":
                        log.info("覆盖文件: " + outputPath);
                        break;
                    case "2":
                        log.info("跳过文件: " + outputPath);
                        return;
                    case "3":
                        allOverwrite = true;
                        log.info("全部覆盖模式，覆盖文件: " + outputPath);
                        break;
                    case "4":
                        allSkip = true;
                        log.info("跳过所有已存在文件模式，跳过文件: " + outputPath);
                        return;
                    default:
                        break;
                }
            }
        }

        Files.createDirectories(outputPath.getParent());
        try (Writer out = new FileWriter(outputPath.toFile())) {
            template.process(dataModel, out);
        }
    }

    private Path determineOutputPath(Path outputDir, String relativePath, String tableName, String packageName) {
        if (packageName != null && !packageName.isEmpty()) {
            outputDir = outputDir.resolve(packageName.replace(".", "/"));
        }
        Path businessDir = outputDir.resolve(StringUtils.lowerCaseFirstLetter(tableName));
        return businessDir.resolve(relativePath.replace("Business", tableName).replace(".ftl", ""));
    }

    protected abstract Path getTemplateDirPath();
    protected abstract Map<String, Object> getDataModel(TemplateTable templateTable);
}
