package com.neegix.database.strategy;


/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/05/17:17
 * @Description:
 */
public class OracleQueryStrategy implements DatabaseQueryStrategy {
    @Override
    public String buildQuery(String tableName, String schemaOrOwner) {
        String whereSchemaOrOwner = schemaOrOwner==null||schemaOrOwner.isEmpty()?"": "AND a.OWNER = '"+schemaOrOwner.toUpperCase()+"'";

        //return "SELECT a.COLUMN_NAME, a.DATA_TYPE, a.NULLABLE AS IS_NULLABLE, a.DATA_DEFAULT AS COLUMN_DEFAULT, b.COMMENTS AS DESCRIPTION FROM ALL_TAB_COLUMNS a LEFT JOIN ALL_COL_COMMENTS b ON a.OWNER = b.OWNER AND a.TABLE_NAME = b.TABLE_NAME AND a.COLUMN_NAME = b.COLUMN_NAME WHERE a.TABLE_NAME = '" + tableName.toUpperCase() + "'" + (schemaOrOwner==null||schemaOrOwner.isEmpty()?"":" AND a.OWNER='"+schemaOrOwner.toUpperCase()+"'");
        return """
                SELECT
                    a.COLUMN_NAME,
                    a.DATA_TYPE,
                    a.NULLABLE AS IS_NULLABLE,
                    a.DATA_DEFAULT AS COLUMN_DEFAULT,
                    b.COMMENTS AS DESCRIPTION,
                    CASE\s
                        WHEN pk.COLUMN_NAME IS NOT NULL THEN TRUE\s
                        ELSE FALSE\s
                    END AS IS_PRIMARY_KEY,
                    c.COMMENTS AS TABLE_DESCRIPTION
                FROM
                    ALL_TAB_COLUMNS a
                LEFT JOIN ALL_COL_COMMENTS b ON
                    a.OWNER = b.OWNER
                    AND a.TABLE_NAME = b.TABLE_NAME
                    AND a.COLUMN_NAME = b.COLUMN_NAME
                LEFT JOIN (
                    SELECT col.COLUMN_NAME, col.TABLE_NAME, col.OWNER
                    FROM ALL_CONS_COLUMNS col
                    JOIN ALL_CONSTRAINTS cons ON
                        col.CONSTRAINT_NAME = cons.CONSTRAINT_NAME
                        AND col.OWNER = cons.OWNER
                    WHERE cons.CONSTRAINT_TYPE = 'P'
                ) pk ON
                    a.OWNER = pk.OWNER
                    AND a.TABLE_NAME = pk.TABLE_NAME
                    AND a.COLUMN_NAME = pk.COLUMN_NAME
                LEFT JOIN ALL_TAB_COMMENTS c ON
                    a.OWNER = c.OWNER
                    AND a.TABLE_NAME = c.TABLE_NAME
                WHERE
                    a.TABLE_NAME = '%s'
                    %s
                """.formatted(tableName, whereSchemaOrOwner);
    }
}
