package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Role;
import com.codecool.queststore.mappers.RoleMapper;

import java.sql.SQLException;

public class RoleRepository extends AbstractRepository<Role> {
    private static final String ADD_QUERY = "INSERT INTO artifacts(name) VALUES(?)";
    private static final String EDIT_QUERY = "INSERT INTO artifacts(name) VALUES(?) WHERE id=?";
    private static final String DELETE_QUERY = "DELETE * FROM artifacts WHERE id=?";

    public RoleRepository() throws PersistenceLayerException {
        super.mapper = new RoleMapper();
    }

    @Override
    void addEntity(Role entity) throws SQLException {

    }

    @Override
    void updateEntity(Role entity) throws SQLException {

    }

    @Override
    void deleteEntity(Role entity) throws SQLException {

    }
}
