package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.SQLException;

public class AllCodecoolClass extends SqlCriteria {
    static {
        QUERY = "SELECT * FROM classes";
    }

    public AllCodecoolClass() throws PersistenceLayerException {}

    @Override
    protected void setStatementValues() throws SQLException {}
}
