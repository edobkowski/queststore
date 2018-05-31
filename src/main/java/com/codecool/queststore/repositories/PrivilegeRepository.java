package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Privilege;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.List;

public class PrivilegeRepository extends AbstractRepository<Privilege> {
    public PrivilegeRepository() throws PersistenceLayerException {}

    @Override
    void addEntity(Privilege entity) throws SQLException {

    }

    @Override
    void updateEntity(Privilege entity) throws SQLException {

    }

    @Override
    void deleteEntity(Privilege entity) throws SQLException {

    }

    @Override
    List<Privilege> deserializeEntities() throws SQLException {
        return null;
    }
}
