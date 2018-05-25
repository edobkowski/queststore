package com.codecool.queststore.specifications;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArtifactById implements SqlSpecification {
    private static final String QUERY = "SELECT * FROM artifacts WHERE id=?";
    private PreparedStatement statement;
    private final int id;

    private final Connection connection;

    public ArtifactById(int id) throws SQLException {
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