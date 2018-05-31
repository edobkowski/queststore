package com.codecool.queststore.mappers;

import com.codecool.queststore.model.entities.Privilege;
import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrivilegeMapper implements Mapper<Privilege> {
    @Override
    public Privilege map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
        return null;
    }
}
