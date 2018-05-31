package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Level;
import com.codecool.queststore.mappers.LevelMapper;

import java.sql.SQLException;

public class LevelRepository extends AbstractRepository<Level> {
    public LevelRepository() throws PersistenceLayerException {
        super.mapper = new LevelMapper();
    }

    @Override
    void addEntity(Level entity) throws SQLException {

    }

    @Override
    void updateEntity(Level entity) throws SQLException {

    }

    @Override
    void deleteEntity(Level entity) throws SQLException {

    }
}
