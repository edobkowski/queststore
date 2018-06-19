package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.SQLException;

public abstract class GetById extends SqlCriteria {
    private final int id;

    public GetById(int id) throws PersistenceLayerException {
        this.id = id;
    }

    @Override
    protected void setStatementValues() throws SQLException {
        this.statement.setInt(1, this.id);
    }
}
