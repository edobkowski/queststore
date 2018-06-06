package com.codecool.queststore.criteria;

import com.codecool.queststore.ConnectionProvider;
import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class SqlCriteria {
    private Connection connection;
    protected PreparedStatement statement;

    protected static String QUERY;

    public SqlCriteria() throws PersistenceLayerException {
        this.connection = ConnectionProvider.getConnection();
        try {
            this.statement = this.connection.prepareStatement(QUERY);
            setStatementValues();
        } catch (SQLException e) {
            throw new PersistenceLayerException("Can't handle " + this.getClass().getSimpleName()
                    + "criterion due to exception occurance when creating PreparedStatement");
        }
    }

    protected abstract void setStatementValues() throws SQLException;

    public PreparedStatement toPreparedStatement() {
        return this.statement;
    }
}
