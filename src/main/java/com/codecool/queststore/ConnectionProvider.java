package com.codecool.queststore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionProvider {
    private static Connection instance;

    private ConnectionProvider() {}

    public static Connection getInstance() {
        if (instance == null) {
            try {
                instance = DriverManager.getConnection("jdbc:postgresql://localhost:5432/queststore", "postgres", "postgres");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return instance;
    }
}
