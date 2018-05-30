package com.codecool.queststore.criteria;

import java.sql.SQLException;

public class CodecoolClassByName extends SqlCriteria {
    private final String name;

    static {
        QUERY = "SELECT * FROM classes WHERE name=?";
    }

    public CodecoolClassByName(String name) throws SQLException {
        this.name = name;
    }

    @Override
    protected void setStatementValues() throws SQLException {
        this.statement.setString(1, this.name);
    }
}
