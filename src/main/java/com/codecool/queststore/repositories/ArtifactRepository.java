package com.codecool.queststore.repositories;

import com.codecool.queststore.model.Artifact;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.List;

public class ArtifactRepository extends AbstractRepository<Artifact> {
    public ArtifactRepository() throws PersistenceLayerException {}

    private static final String ADD_QUERY = "INSERT INTO artifacts(name, description, price) VALUES(?,?,?)";
    private static final String EDIT_QUERY = "INSERT INTO artifacts(name, description, price) VALUES(?,?,?) WHERE id=?";
    private static final String DELETE_QUERY = "DELETE * FROM artifacts WHERE id=?";

    @Override
    void addEntity(Artifact entity) throws SQLException {
        super.preparedStatement.setString(1, entity.getName());
        super.preparedStatement.setString(2, entity.getDescription());
        super.preparedStatement.setInt(3, entity.getPrice());
        super.preparedStatement = super.dbConnection.prepareStatement(ADD_QUERY);
        super.preparedStatement.executeUpdate();
    }

    @Override
    void updateEntity(Artifact entity) throws SQLException {
        super.preparedStatement.setString(1, entity.getName());
        super.preparedStatement.setString(2, entity.getDescription());
        super.preparedStatement.setInt(3, entity.getPrice());
        super.preparedStatement.setInt(4, entity.getId);
        super.preparedStatement = super.dbConnection.prepareStatement(EDIT_QUERY);
        super.preparedStatement.executeUpdate();
    }

    @Override
    void deleteEntity(Artifact entity) throws SQLException {
        super.preparedStatement.setId(1, entity.getId());
        super.preparedStatement = super.dbConnection.prepareStatement(DELETE_QUERY);
        super.preparedStatement.executeUpdate();
    }

    @Override
    List<Artifact> queryEntities(SqlSpecification sqlSpecification) throws SQLException {
        return null;
    }
}
