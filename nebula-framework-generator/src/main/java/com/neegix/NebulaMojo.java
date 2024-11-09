package com.neegix;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.neegix.database.ColumnMetadata;
import com.neegix.database.DatabaseMetadata;
import com.neegix.template.TemplateTable;
import com.neegix.template.factory.TemplateDataFactory;
import com.neegix.template.factory.TemplateHandlerFactory;
import com.neegix.template.strategy.TemplateFileModelStrategy;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.sql.SQLException;
import java.util.List;

@Mojo(name = "generator", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class NebulaMojo extends AbstractMojo {
    @Parameter(required = true)
    private String driver;
    @Parameter(required = true)
    private String url;
    @Parameter(required = true)
    private String username;
    @Parameter(required = true)
    private String password;
    @Parameter(required = true)
    private String tableName;
    @Parameter
    private String tablePrefix;
    @Parameter(required = true)
    private String packageName;
    @Parameter
    private String schemaOrOwner;
    @Parameter(required = true)
    private String outputDir;

    @Parameter(defaultValue = "ddd")
    private String templateType;

    public void execute()
    {
        Log log = this.getLog();
        DatabaseMetadata dbMetadata = new DatabaseMetadata(driver, url, username, password, schemaOrOwner, log);
        try {
            log.info("准备链接...");
            dbMetadata.connect();

            List<ColumnMetadata> columns = dbMetadata.getColumns(tableName);
            log.info("列信息获取完成...");

            log.info("开始构建模板数据...");
            TemplateTable templateTable = TemplateDataFactory.create(tableName, tablePrefix, packageName, columns, driver, log);
            log.info("模板数据构建完成...");

            log.info("开始选择模板["+templateType+"]...");
            TemplateFileModelStrategy domainModelGenerator = TemplateHandlerFactory.createStrategy(templateType, outputDir);
            log.info("模板["+templateType+"]选择结束...");
            log.info("开始生成模板...");
            domainModelGenerator.generate(templateTable, log);
            log.info("模板生成完毕...");

        } catch (ClassNotFoundException | SQLException e) {
            log.error("Failed to execute query: " + (driver.equals(e.getMessage()) ? "未加载驱动[" + driver + "]" : e.getMessage()));
        }
    }
}
