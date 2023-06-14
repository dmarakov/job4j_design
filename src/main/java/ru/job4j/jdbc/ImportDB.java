package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class ImportDB {

    private Properties cfg;
    private String dump;

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() {
        AtomicInteger currentLine = new AtomicInteger(1);
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(line -> {
                String[] splitedLine = line.split(";");
                if (splitedLine.length != 2 || splitedLine[0] == null || splitedLine[1] == null) {
                    throw new IllegalArgumentException("Not valid argument on line " + currentLine);
                }
                users.add(new User(splitedLine[0], splitedLine[1]));
                currentLine.getAndIncrement();
            });
        } catch (Exception e) {
            LOG.error("Exception", e);
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        );
             PreparedStatement preparedStatement = cnt.prepareStatement("CREATE TABLE IF NOT EXISTS users(ID serial,name varchar(100), email varchar(100));")) {
            preparedStatement.execute();
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("INSERT INTO users(name,email) VALUES(?,?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./dump.txt");
        db.save(db.load());
    }
}