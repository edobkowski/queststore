package com.codecool.queststore.repositories;

import com.codecool.queststore.model.Level;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.List;

public class LevelRepository extends AbstractRepository<Level> {
    public LevelRepository() throws PersistenceLayerException {}

    @Override
    void addEntity(Level entity) throws SQLException {

    }

    @Override
    void updateEntity(Level entity) throws SQLException {

    }

    @Override
    void deleteEntity(Level entity) throws SQLException {

    }

    @Override
    List<Level> queryEntities(SqlSpecification sqlSpecification) throws SQLException {
        return null;
    }
}
