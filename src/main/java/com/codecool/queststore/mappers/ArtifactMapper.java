package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.Artifact;
import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtifactMapper implements Mapper {
    @Override
    public Artifact map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        int price = resultSet.getInt("price");

        return new Artifact(id, name, description, price);
    }
}
