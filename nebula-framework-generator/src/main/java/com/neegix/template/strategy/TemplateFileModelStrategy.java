package com.neegix.template.strategy;

import com.neegix.template.TemplateTable;
import org.apache.maven.plugin.logging.Log;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/14:29
 * @Description:
 */
public interface TemplateFileModelStrategy {
    void generate(TemplateTable templateTable, Log log);
}
