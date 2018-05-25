package com.codecool.queststore.specifications;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentByLogin implements SqlSpecification {
    private static final String QUERY = "SELECT * FROM students WHERE login=?";

    private final Connection connection;
    private PreparedStatement statement;

    private final String login;

    public StudentByLogin(String login) throws SQLException {
        this.login = login;
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/queststore",
                "postgres",
                "postgres");
        initialize();
    }

    private void initialize() throws SQLException {
        this.statement = this.connection.prepareStatement(QUERY);
        this.statement.setString(1, this.login);
    }
    @Override
    public PreparedStatement toQuery() {
        return this.statement;
    }
}
