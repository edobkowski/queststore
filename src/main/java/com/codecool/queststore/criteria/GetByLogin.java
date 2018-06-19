package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.SQLException;

public abstract class GetByLogin extends SqlCriteria {
    private final String login;

    public GetByLogin(String login) throws PersistenceLayerException {
        this.login = login;
    }

    @Override
    protected void setStatementValues() throws SQLException {
        this.statement.setString(1, this.login);
    }
}
