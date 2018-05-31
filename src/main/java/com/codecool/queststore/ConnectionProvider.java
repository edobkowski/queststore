package com.codecool.queststore;

import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionProvider {
    private static Connection connection;

    public static Connection getConnection() throws PersistenceLayerException {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/queststore", "postgres", "postgres");
            } catch (SQLException e) {
                throw new PersistenceLayerException("Can't get connection to the database");
            }
        }

        return connection;
    }
}
