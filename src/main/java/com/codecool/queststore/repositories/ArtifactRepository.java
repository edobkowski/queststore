package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Artifact;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtifactRepository extends AbstractRepository<Artifact> {
    public ArtifactRepository() throws PersistenceLayerException {}

    private static final String ADD_QUERY = "INSERT INTO artifacts(name, description, price) VALUES(?,?,?)";
    private static final String EDIT_QUERY = "INSERT INTO artifacts(name, description, price) VALUES(?,?,?) WHERE id=?";
    private static final String DELETE_QUERY = "DELETE * FROM artifacts WHERE id=?";

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

    @Override
    List<Artifact> deserializeEntities() throws SQLException {
        List<Artifact> artifacts = new ArrayList<>();

        while (super.resultSet.next()) {
            int id = super.resultSet.getInt("id");
            String name = super.resultSet.getString("name");
            String description = super.resultSet.getString("description");
            int price = super.resultSet.getInt("price");

            artifacts.add(new Artifact(id, name, description, price));
        }
        return artifacts;
    }
}
