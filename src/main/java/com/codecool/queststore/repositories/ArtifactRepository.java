package com.codecool.queststore.repositories;

import com.codecool.queststore.mappers.ArtifactMapper;
import com.codecool.queststore.model.entities.Artifact;

import java.sql.SQLException;

public class ArtifactRepository extends AbstractRepository<Artifact> {
    private static final String ADD_QUERY = "INSERT INTO artifacts(name, description, price) VALUES(?,?,?)";
    private static final String EDIT_QUERY = "INSERT INTO artifacts(name, description, price) VALUES(?,?,?) WHERE id=?";
    private static final String DELETE_QUERY = "DELETE * FROM artifacts WHERE id=?";

    public ArtifactRepository() throws PersistenceLayerException {
        super.mapper = new ArtifactMapper();
    }

    @Override
    void addEntity(Artifact entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(ADD_QUERY);
        super.preparedStatement.setString(1, entity.getName());
        super.preparedStatement.setString(2, entity.getDescription());
        super.preparedStatement.setInt(3, entity.getPrice());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void updateEntity(Artifact entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(EDIT_QUERY);
        super.preparedStatement.setString(1, entity.getName());
        super.preparedStatement.setString(2, entity.getDescription());
        super.preparedStatement.setInt(3, entity.getPrice());
        super.preparedStatement.setInt(4, entity.getId());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void deleteEntity(Artifact entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(DELETE_QUERY);
        super.preparedStatement.setInt(1, entity.getId());
        super.preparedStatement.executeUpdate();
    }
}
