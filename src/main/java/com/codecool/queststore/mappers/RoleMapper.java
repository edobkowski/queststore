package com.codecool.queststore.mappers;

import com.codecool.queststore.model.entities.Role;
import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements Mapper<Role> {
    @Override
    public Role map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
        return null;
    }
}
