package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.SQLException;

public class AllLevels extends SqlCriteria {
    static {
        QUERY = "SELECT * FROM levels";
    }

    public AllLevels() throws PersistenceLayerException {}

    @Override
    protected void setStatementValues() throws SQLException {}
}
