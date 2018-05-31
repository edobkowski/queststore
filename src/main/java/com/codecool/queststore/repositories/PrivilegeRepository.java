package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Privilege;
import com.codecool.queststore.mappers.PrivilegeMapper;
import java.sql.SQLException;

public class PrivilegeRepository extends AbstractRepository<Privilege> {
    private static final String ADD_QUERY = "INSERT INTO privileges(name) VALUES(?)";
    private static final String EDIT_QUERY = "INSERT INTO privileges(name) VALUES(?) WHERE id=?";
    private static final String DELETE_QUERY = "DELETE * FROM privileges WHERE id=?";

    public PrivilegeRepository() throws PersistenceLayerException {
        super.mapper = new PrivilegeMapper();
    }

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
}
