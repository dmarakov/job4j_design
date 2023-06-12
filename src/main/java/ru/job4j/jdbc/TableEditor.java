package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("jdbc.driver"));
        String url = properties.getProperty("jdbc.url");
        String login = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void getStatement(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void createTable(String tableName) throws SQLException {
        String sql = String.format(
                "CREATE TABLE IF NOT EXISTS %s();",
                tableName
        );
        getStatement(sql);
    }


    public void dropTable(String tableName) throws SQLException {
        String sql = String.format(
                "DROP TABLE %s;",
                tableName
        );
        getStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s ADD %s %s;",
                tableName,
                columnName,
                type
        );
        getStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s DROP COLUMN %s;",
                tableName,
                columnName
        );
        getStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s RENAME COLUMN %s TO %s",
                tableName,
                columnName,
                newColumnName
        );
        getStatement(sql);
    }


    public String getTableScheme(String tableName) throws SQLException {
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
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
            try (TableEditor tb = new TableEditor(config)) {
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
    }
}