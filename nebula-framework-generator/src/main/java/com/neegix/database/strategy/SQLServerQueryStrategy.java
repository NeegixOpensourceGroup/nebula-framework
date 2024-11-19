package com.neegix.database.strategy;


/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/05/17:18
 * @Description:
 */
public class SQLServerQueryStrategy implements DatabaseQueryStrategy {
    @Override
    public String buildQuery(String tableName, String schemaOrOwner) {
        String objectSchemaOrOwner = schemaOrOwner==null||schemaOrOwner.isEmpty()?"":schemaOrOwner+"."+tableName;
        String whereSchemaOrOwner = schemaOrOwner==null||schemaOrOwner.isEmpty()?"": "AND C.TABLE_SCHEMA='"+schemaOrOwner.toUpperCase()+"'";
        return """
                SELECT
                    C.COLUMN_NAME,
                    C.DATA_TYPE,
                    C.IS_NULLABLE,
                    C.COLUMN_DEFAULT,
                    EP.value AS DESCRIPTION,
                    CASE\s
                        WHEN KC.COLUMN_NAME IS NOT NULL THEN TRUE\s
                        ELSE FALSE\s
                    END AS IS_PRIMARY_KEY,
                    TP.value AS TABLE_DESCRIPTION
                FROM
                    INFORMATION_SCHEMA.COLUMNS C
                LEFT JOIN sys.columns SC ON
                    SC.name = C.COLUMN_NAME
                    AND SC.object_id = OBJECT_ID('%s')
                LEFT JOIN sys.extended_properties EP ON
                    EP.major_id = SC.object_id
                    AND EP.minor_id = SC.column_id
                    AND EP.name = 'MS_Description'
                LEFT JOIN (
                    SELECT\s
                        COL_NAME(ic.object_id, ic.column_id) AS COLUMN_NAME,\s
                        ic.object_id
                    FROM\s
                        sys.indexes i
                    INNER JOIN\s
                        sys.index_columns ic ON i.index_id = ic.index_id AND i.object_id = ic.object_id
                    INNER JOIN\s
                        sys.key_constraints kc ON i.name = kc.name
                    WHERE\s
                        kc.type = 'PK'
                ) KC ON\s
                    KC.COLUMN_NAME = C.COLUMN_NAME\s
                    AND KC.object_id = OBJECT_ID('%s')
                LEFT JOIN sys.extended_properties TP ON
                    TP.major_id = OBJECT_ID('%s')
                    AND TP.minor_id = 0
                    AND TP.name = 'MS_Description'
                WHERE
                    C.TABLE_NAME = '%s'
                    %s;
                """.formatted(objectSchemaOrOwner, objectSchemaOrOwner, tableName, whereSchemaOrOwner);
    }
}

