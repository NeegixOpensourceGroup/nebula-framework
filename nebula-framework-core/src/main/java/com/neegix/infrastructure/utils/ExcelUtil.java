package com.neegix.infrastructure.utils;

import cn.idev.excel.ExcelWriter;
import cn.idev.excel.FastExcel;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.read.listener.ReadListener;
import cn.idev.excel.write.metadata.WriteSheet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/07/16/17:34
 * @Description:
 */
public class ExcelUtil {
    /**
     * 通用导出方法
     * @param dataList 导出的数据列表
     * @param fileName 导出文件名（不带后缀）
     * @param sheetName sheet名称
     * @param clazz 数据模型类
     * @param <T> 数据类型
     * @throws IOException
     */
    public static <T> void export(List<T> dataList, String fileName, String sheetName, Class<T> clazz) throws IOException {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            throw new RuntimeException("当前无请求上下文");
        }

        HttpServletResponse response = servletRequestAttributes.getResponse();
        if (response == null) {
            throw new RuntimeException("无法获取响应对象");
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        FastExcel.write(response.getOutputStream(), clazz)
                .sheet(sheetName)
                .doWrite(dataList);
    }

    /**
     * 分批次导出大数据量
     * @param dataSupplier 数据提供者（分页查询）
     * @param fileName 导出文件名
     * @param sheetName sheet名称
     * @param clazz 数据模型类
     * @param pageSize 每批次大小
     * @param <T> 数据类型
     * @throws IOException
     */
    public static <T> void exportBigData(DataSupplier<T> dataSupplier, String fileName, String sheetName,
                                         Class<T> clazz, int pageSize) throws IOException {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            throw new RuntimeException("当前无请求上下文");
        }

        HttpServletResponse response = servletRequestAttributes.getResponse();
        if (response == null) {
            throw new RuntimeException("无法获取响应对象");
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        ExcelWriter excelWriter = null;
        try {
            excelWriter = FastExcel.write(response.getOutputStream(), clazz).build();
            WriteSheet writeSheet = FastExcel.writerSheet(sheetName).build();

            int page = 1;
            while (true) {
                List<T> data = dataSupplier.getData(page, pageSize);
                if (data == null || data.isEmpty()) {
                    break;
                }

                excelWriter.write(data, writeSheet);
                page++;
            }
        } finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    public interface DataSupplier<T> {
        List<T> getData(int page, int pageSize);
    }

    /**
     * 通用导入方法
     * @param inputStream 文件输入流
     * @param clazz 数据模型类
     * @param consumer 消费数据的函数
     * @param <T> 数据类型
     */
    public static <T> void importExcel(InputStream inputStream, Class<T> clazz, Consumer<T> consumer) {
        FastExcel.read(inputStream, clazz, new ReadListener<T>() {
            @Override
            public void invoke(T data, AnalysisContext context) {
                consumer.accept(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 所有数据解析完成后的操作
            }
        }).sheet().doRead();
    }
}
