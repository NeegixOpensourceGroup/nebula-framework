package com.neegix.database.strategy;


/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/05/17:17
 * @Description:
 */
public class MySQLQueryStrategy implements DatabaseQueryStrategy {
    @Override
    public String buildQuery(String tableName, String schemaOrOwner) {
        String whereSchemaOrOwner = schemaOrOwner==null||schemaOrOwner.isEmpty()?"": "AND c.TABLE_SCHEMA='"+schemaOrOwner+"'";

        //return "SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_DEFAULT, COLUMN_COMMENT AS DESCRIPTION FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + tableName + "'" + (schemaOrOwner==null||schemaOrOwner.isEmpty()?"":" AND TABLE_SCHEMA='"+schemaOrOwner+"'");
        return """
                SELECT
                    c.COLUMN_NAME,
                    c.DATA_TYPE,
                    c.IS_NULLABLE,
                    c.COLUMN_DEFAULT,
                    c.COLUMN_COMMENT AS DESCRIPTION,
                    CASE\s
                        WHEN k.COLUMN_NAME IS NOT NULL  THEN TRUE\s
                        ELSE FALSE\s
                    END AS IS_PRIMARY_KEY,
                    t.TABLE_COMMENT AS TABLE_DESCRIPTION
                FROM
                    INFORMATION_SCHEMA.COLUMNS c
                LEFT JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE k ON\s
                    c.TABLE_SCHEMA = k.TABLE_SCHEMA
                    AND c.TABLE_NAME = k.TABLE_NAME
                    AND c.COLUMN_NAME = k.COLUMN_NAME
                    AND k.CONSTRAINT_NAME = 'PRIMARY'
                LEFT JOIN INFORMATION_SCHEMA.TABLES t ON
                    c.TABLE_SCHEMA = t.TABLE_SCHEMA
                    AND c.TABLE_NAME = t.TABLE_NAME
                WHERE
                    c.TABLE_NAME = '%s'
                    %s
                """.formatted(tableName, whereSchemaOrOwner);
    }
}
