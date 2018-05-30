package com.codecool.queststore.criteria;

import com.codecool.queststore.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class SqlCriteria {
    private Connection connection;
    protected PreparedStatement statement;

    protected static String QUERY;

    public SqlCriteria() throws SQLException {
        this.connection = ConnectionProvider.getInstance();
        this.statement = this.connection.prepareStatement(QUERY);
        setStatementValues();
    }

    protected abstract void setStatementValues() throws SQLException;

    public PreparedStatement toPreparedStatement() {
        return this.statement;
    }
}
