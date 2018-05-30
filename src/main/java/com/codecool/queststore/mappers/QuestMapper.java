package com.codecool.queststore.mappers;

import com.codecool.queststore.model.entities.Quest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestMapper implements Mapper {
    @Override
    public Quest map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        int reward = resultSet.getInt("reward");

        return new Quest(id, name, description, reward);
    }
}
