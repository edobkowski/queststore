package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.User;
import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
//        TODO
        return null;
    }
}
