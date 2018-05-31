package com.codecool.queststore.mappers;

import com.codecool.queststore.model.entities.User;
import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
        return null;
    }
}
