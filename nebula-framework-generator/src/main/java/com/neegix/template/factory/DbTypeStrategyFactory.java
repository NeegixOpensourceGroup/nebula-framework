package com.neegix.template.factory;

import com.neegix.template.strategy.DbTypeMapper;
import com.neegix.template.strategy.MySqlDbTypeMapper;
import com.neegix.template.strategy.OracleDbTypeMapper;
import com.neegix.template.strategy.SqlServerDbTypeMapper;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/11:10
 * @Description:
 */
public class DbTypeStrategyFactory {
    public static DbTypeMapper createStrategy(String driver) {
        if (driver.contains("mysql")) {
            return new MySqlDbTypeMapper();
        } else if (driver.contains("oracle")) {
            return new OracleDbTypeMapper();
        } else if (driver.contains("sqlserver")) {
            return new SqlServerDbTypeMapper();
        } else {
            throw new IllegalArgumentException("Unsupported db type mapper: " + driver);
        }
    }
}
