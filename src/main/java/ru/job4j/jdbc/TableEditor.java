package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
            Class.forName(config.getProperty("driver_class"));
            String url = config.getProperty("url");
            String login = config.getProperty("login");
            String password = config.getProperty("password");
            connection = DriverManager.getConnection(url, login, password);
        }
    }

    public void getStatement(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void createTable(String tableName) throws Exception {
        String sql = String.format(
                "CREATE TABLE IF NOT EXISTS %s();",
                tableName
        );
        getStatement(sql);
    }


    public void dropTable(String tableName) throws Exception {
        String sql = String.format(
                "DROP TABLE %s;",
                tableName
        );
        getStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String sql = String.format(
                "ALTER TABLE %s ADD %s %s;",
                tableName,
                columnName,
                type
        );
        getStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        String sql = String.format(
                "ALTER TABLE %s DROP COLUMN %s;",
                tableName,
                columnName
        );
        getStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        String sql = String.format(
                "ALTER TABLE %s RENAME COLUMN %s TO %s",
                tableName,
                columnName,
                newColumnName
        );
        getStatement(sql);
    }


    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        TableEditor tb = new TableEditor(new Properties());
        DatabaseMetaData metaData = tb.connection.getMetaData();
        System.out.println(metaData.getUserName());
        System.out.println(metaData.getURL());
        tb.createTable("JDBC");
        System.out.println(tb.getTableScheme("JDBC"));
        tb.addColumn("JDBC", "Model", "TEXT");
        System.out.println(tb.getTableScheme("JDBC"));
        tb.renameColumn("JDBC", "Model", "New_Model");
        System.out.println(tb.getTableScheme("JDBC"));
        tb.dropColumn("JDBC", "new_model");
        System.out.println(tb.getTableScheme("JDBC"));
        tb.dropTable("JDBC");

    }
}