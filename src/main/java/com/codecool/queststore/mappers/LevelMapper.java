package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.Level;
import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LevelMapper implements Mapper<Level> {
    @Override
    public Level map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
//        TODO
        return null;
    }
}
