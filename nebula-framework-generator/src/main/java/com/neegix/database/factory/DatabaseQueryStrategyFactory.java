package com.neegix.database.factory;

import com.neegix.database.strategy.DatabaseQueryStrategy;
import com.neegix.database.strategy.MySQLQueryStrategy;
import com.neegix.database.strategy.OracleQueryStrategy;
import com.neegix.database.strategy.SQLServerQueryStrategy;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/05/17:21
 * @Description:
 */
public class DatabaseQueryStrategyFactory {
    public static DatabaseQueryStrategy createStrategy(String driver) {
        if (driver.contains("mysql")) {
            return new MySQLQueryStrategy();
        } else if (driver.contains("oracle")) {
            return new OracleQueryStrategy();
        } else if (driver.contains("sqlserver")) {
            return new SQLServerQueryStrategy();
        } else {
            throw new IllegalArgumentException("Unsupported database driver: " + driver);
        }
    }
}
