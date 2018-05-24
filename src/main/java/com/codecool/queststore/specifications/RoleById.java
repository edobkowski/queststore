package com.codecool.queststore.specifications;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleById implements SqlSpecification {
    private static final String QUERY = "SELECT * FROM roles WHERE id=?";

    private final Connection connection;
    private PreparedStatement statement;

    private final int id;

    public RoleById(int id) throws SQLException {
        this.id = id;
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/queststore",
                "postgres",
                "postgres");
        initialize();
    }

    private void initialize() throws SQLException {
        this.statement = this.connection.prepareStatement(QUERY);
        this.statement.setInt(1, this.id);
    }
    @Override
    public PreparedStatement toQuery() {
        return this.statement;
    }
}
