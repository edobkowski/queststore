package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Role;
import com.codecool.queststore.mappers.RoleMapper;

import java.sql.SQLException;

public class RoleRepository extends AbstractRepository<Role> {
    private static final String ADD_QUERY = "INSERT INTO roles(name) VALUES(?)";
    private static final String EDIT_QUERY = "INSERT INTO roles(name) VALUES(?) WHERE id=?";
    private static final String DELETE_QUERY = "DELETE * FROM roles WHERE id=?";

    public RoleRepository() throws PersistenceLayerException {
        super.mapper = new RoleMapper();
    }

    @Override
    void addEntity(Role entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(ADD_QUERY);
        super.preparedStatement.setString(1, entity.getName());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void updateEntity(Role entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(EDIT_QUERY);
        super.preparedStatement.setString(1, entity.getName());
        super.preparedStatement.setInt(2, entity.getId());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void deleteEntity(Role entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(DELETE_QUERY);
        super.preparedStatement.setInt(1, entity.getId());
        super.preparedStatement.executeUpdate();
    }
}
