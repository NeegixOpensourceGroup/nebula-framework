package com.neegix.template.handler;

import com.neegix.template.TemplateTable;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/14:30
 * @Description:
 */
public class NebulaModelTemplateFile extends AbstractTemplateFileGenerator {
    public NebulaModelTemplateFile(String outputBaseDir) {
        super(outputBaseDir);
    }

    @Override
    protected Path getTemplateDirPath() {
        return Paths.get(File.separator+"templates"+File.separator+"nebula");
    }

    @Override
    protected Map<String, Object> getDataModel(TemplateTable templateTable) {
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("templateTable", templateTable);
        return dataModel;
    }
}