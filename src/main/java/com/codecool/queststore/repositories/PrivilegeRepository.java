package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Privilege;
import com.codecool.queststore.mappers.PrivilegeMapper;

import java.sql.SQLException;

public class PrivilegeRepository extends AbstractRepository<Privilege> {
    public PrivilegeRepository() throws PersistenceLayerException {
        super.mapper = new PrivilegeMapper();
    }

    @Override
    void addEntity(Privilege entity) throws SQLException {

    }

    @Override
    void updateEntity(Privilege entity) throws SQLException {

    }

    @Override
    void deleteEntity(Privilege entity) throws SQLException {

    }
}
