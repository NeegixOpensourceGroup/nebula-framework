package com.neegix.database;

import com.neegix.database.strategy.DatabaseQueryStrategy;
import com.neegix.database.factory.DatabaseQueryStrategyFactory;
import org.apache.maven.plugin.logging.Log;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/05/15:40
 * @Description:
 */
public class DatabaseMetadata implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String url;
    private final String username;
    private final String password;
    private final String driver;
    private final String schemaOrOwner;
    private final DatabaseQueryStrategy queryStrategy;
    private final Log log;

    public DatabaseMetadata(String driver, String url, String username, String password, String schemaOrOwner, Log log) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
        this.log = log;
        this.schemaOrOwner = schemaOrOwner;
        this.queryStrategy = DatabaseQueryStrategyFactory.createStrategy(driver);
    }

    public void connect() throws SQLException, ClassNotFoundException {
        // 注册 JDBC 驱动
        log.info("驱动加载：" + driver);
        Class.forName(driver);
    }

    public List<ColumnMetadata> getColumns(String tableName) throws SQLException {
        // 打开连接
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement()) {
            log.info("打开链接：" + con);
            // 根据不同的数据库类型构建查询语句
            String query = queryStrategy.buildQuery(tableName, schemaOrOwner);
            log.info("SQL语句：" + query);
            // 执行查询并处理结果集
            List<ColumnMetadata> columns = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    String columnName = rs.getString("COLUMN_NAME");
                    String dataType = rs.getString("DATA_TYPE");
                    String isNullable = rs.getString("IS_NULLABLE");
                    boolean isPrimaryKey = rs.getBoolean("IS_PRIMARY_KEY");
                    String defaultValue = rs.getString("COLUMN_DEFAULT");
                    String description = rs.getString("DESCRIPTION");
                    String tableDescription = rs.getString("TABLE_DESCRIPTION");
                    columns.add(new ColumnMetadata(columnName, dataType, isNullable, isPrimaryKey, defaultValue, description, tableDescription));
                }
            }
            return columns;
        }
    }

    @Override
    public String toString() {
        return "DatabaseMetadata{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
