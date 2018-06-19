package com.codecool.queststore.repositories;

import com.codecool.queststore.entities.Level;
import com.codecool.queststore.mappers.LevelMapper;

import java.sql.SQLException;

public class LevelRepository extends AbstractRepository<Level> {
    static {
        ADD_QUERY = "";
        EDIT_QUERY = "";
        DELETE_QUERY = "";
        EDIT_QUERY_KEY_INDEX = 0;
    }

    public LevelRepository() throws PersistenceLayerException {
        super.mapper = new LevelMapper();
    }

    @Override
    void fillStatementWithColumnsData(Level entity) throws SQLException {
//        TODO

    }

    @Override
    void addPrimaryKeyToStatement(int queryKeyIndex, Level entity) throws SQLException {
//        TODO

    }
}
