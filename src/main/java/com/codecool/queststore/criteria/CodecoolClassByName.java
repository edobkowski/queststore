package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.SQLException;

public class CodecoolClassByName extends SqlCriteria {
    private final String name;

    static {
        QUERY = "SELECT * FROM classes WHERE name=?";
    }

    public CodecoolClassByName(String name) throws PersistenceLayerException {
        this.name = name;
    }

    @Override
    protected void setStatementValues() throws SQLException {
        this.statement.setString(1, this.name);
    }
}
