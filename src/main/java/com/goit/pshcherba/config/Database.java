package com.goit.pshcherba.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final Connection connection;
    private static Database instance;


    private Database() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:h2:./data/megasoft", "sa", "");
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null || instance.connection.isClosed()) {
            instance = new Database();
        }

        return instance.connection;
    }
}
