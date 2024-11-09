package com.neegix.database.strategy;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/05/17:17
 * @Description:
 */
public interface DatabaseQueryStrategy {
    String buildQuery(String tableName, String schemaOrOwner);
}
