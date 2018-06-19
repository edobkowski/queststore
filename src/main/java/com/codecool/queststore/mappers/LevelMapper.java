package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.Level;
import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LevelMapper implements Mapper<Level> {
    @Override
    public Level map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int treshold = resultSet.getInt("treshold");

        return new Level(id, name, treshold);
    }
}
