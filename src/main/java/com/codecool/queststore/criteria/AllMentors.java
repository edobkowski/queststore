package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.SQLException;

public class AllMentors extends SqlCriteria {
    static {
        QUERY = "SELECT * FROM mentors";
    }

    public AllMentors() throws PersistenceLayerException {}

    @Override
    protected void setStatementValues() throws SQLException {}
}
