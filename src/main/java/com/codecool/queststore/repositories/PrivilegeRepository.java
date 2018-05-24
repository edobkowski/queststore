package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Privilege;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PrivilegeRepository extends AbstractRepository<Privilege> {
    private static final String ADD_QUERY = "INSERT INTO privileges(name) VALUES(?)";
    private static final String EDIT_QUERY = "INSERT INTO privileges(name) VALUES(?) WHERE id=?";
    private static final String DELETE_QUERY = "DELETE * FROM privileges WHERE id=?";

    public PrivilegeRepository() throws PersistenceLayerException {}

    @Override
    void addEntity(Privilege entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(ADD_QUERY);
        super.preparedStatement.setString(1, entity.getName());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void updateEntity(Privilege entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(EDIT_QUERY);
        super.preparedStatement.setString(1, entity.getName());
        super.preparedStatement.setInt(2, entity.getId());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void deleteEntity(Privilege entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(DELETE_QUERY);
        super.preparedStatement.setInt(1, entity.getId());
        super.preparedStatement.executeUpdate();
    }

    @Override
    List<Privilege> deserializeEntities() throws SQLException {
        List<Privilege> privileges = new ArrayList<>();

        while (super.resultSet.next()) {
            int id = super.resultSet.getInt("id");
            String name = super.resultSet.getString("name");

            privileges.add(new Privilege(id, name));
        }
        return privileges;
    }
}
