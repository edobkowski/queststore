package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Role;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class RoleRepository extends AbstractRepository<Role> {
    private static final String ADD_QUERY = "INSERT INTO roles(name) VALUES(?)";
    private static final String EDIT_QUERY = "INSERT INTO roles(name) VALUES(?) WHERE id=?";
    private static final String DELETE_QUERY = "DELETE * FROM roles WHERE id=?";

    public RoleRepository() throws PersistenceLayerException {
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

    @Override
    List<Role> deserializeEntities() throws SQLException {
        List<Role> roles = new ArrayList<>();

        while (super.resultSet.next()) {
            int id = super.resultSet.getInt("id");
            String name = super.resultSet.getString("name");

            roles.add(new Role(id, name));
        }
        return roles;
    }
}
