package com.codecool.queststore.mappers;

import com.codecool.queststore.model.entities.CodecoolClass;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodecoolClassMapper implements Mapper {
    @Override
    public CodecoolClass map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return new CodecoolClass(id, name);
    }
}
