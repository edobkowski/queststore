package com.codecool.queststore.criteria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LastCreatedWallet implements SqlCriteria {
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
    public PreparedStatement toPreparedStatement() {
        return this.statement;
    }
}
