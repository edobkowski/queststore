package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AllQuests extends SqlCriteria{

    static {
        QUERY = "SELECT * FROM quests";
    }

    public AllQuests() throws PersistenceLayerException {
        super();
    }

    @Override
    protected void setStatementValues() throws SQLException {
    }

    @Override
    public PreparedStatement toPreparedStatement() {
        return super.toPreparedStatement();
    }
}
