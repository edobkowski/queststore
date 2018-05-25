package com.codecool.queststore.specifications;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LastCreatedWallet implements SqlSpecification {
    private static final String QUERY = "SELECT MAX(id) FROM wallets";

    private final Connection connection;
    private PreparedStatement statement;

    public LastCreatedWallet() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/queststore",
                "postgres",
                "postgres");
        initialize();
    }

    private void initialize() throws SQLException {
        this.statement = this.connection.prepareStatement(QUERY);
    }
    @Override
    public PreparedStatement toQuery() {
        return this.statement;
    }
}
