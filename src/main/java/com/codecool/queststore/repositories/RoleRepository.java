package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Role;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.List;

public class RoleRepository extends AbstractRepository<Role> {
    private static final String ADD_QUERY = "INSERT INTO artifacts(name) VALUES(?)";
    private static final String EDIT_QUERY = "INSERT INTO artifacts(name) VALUES(?) WHERE id=?";
    private static final String DELETE_QUERY = "DELETE * FROM artifacts WHERE id=?";

    public RoleRepository() throws PersistenceLayerException {
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

    @Override
    List<Role> queryEntities(SqlSpecification sqlSpecification) throws SQLException {
        return null;
    }
}
