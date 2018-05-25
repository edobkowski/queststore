package com.codecool.queststore.specifications;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CodecoolClassByName implements SqlSpecification {
    private static final String QUERY = "SELECT * FROM classes WHERE name=?";

    private final Connection connection;
    private PreparedStatement statement;

    private final String name;

    public CodecoolClassByName(String name) throws SQLException {
        this.name = name;
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/queststore",
                "postgres",
                "postgres");
        initialize();
    }

    private void initialize() throws SQLException {
        this.statement = this.connection.prepareStatement(QUERY);
        this.statement.setString(1, this.name);
    }
    @Override
    public PreparedStatement toQuery() {
        return this.statement;
    }
}
