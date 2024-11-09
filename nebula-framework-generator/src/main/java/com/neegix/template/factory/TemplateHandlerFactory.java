package com.neegix.template.factory;

import com.neegix.template.handler.DomainModelTemplateFile;
import com.neegix.template.handler.MvcModelTemplateFile;
import com.neegix.template.strategy.TemplateFileModelStrategy;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/17:47
 * @Description:
 */
public class TemplateHandlerFactory {
    public static TemplateFileModelStrategy createStrategy(String templateType, String outputBaseDir) {
        return switch (templateType) {
            case "ddd" -> new DomainModelTemplateFile(outputBaseDir);
            case "mvc" -> new MvcModelTemplateFile(outputBaseDir);
            default -> throw new IllegalArgumentException("Unsupported template type: " + templateType);
        };
    }
}
