package com.codecool.queststore.mappers;

import com.codecool.queststore.model.entities.Level;
import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LevelMapper implements Mapper<Level> {
    @Override
    public Level map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
        return null;
    }
}
