package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.User;
import com.codecool.queststore.mappers.UserMapper;

import java.sql.SQLException;

public class UserRepository extends AbstractRepository<User> {
    static {
        ADD_QUERY = "INSERT INTO users(login, first_name, last_name, email, role_id, password) VALUES(?,?,?,?,?,?)";
        EDIT_QUERY = "UPDATE users SET login=?, first_name=?, last_name=?, email=?, role_id=?, password=? WHERE login=?";
        DELETE_QUERY = "DELETE * FROM users WHERE login=?";
        EDIT_QUERY_KEY_INDEX = 7;
    }

    public UserRepository() throws PersistenceLayerException {
        super.mapper = new UserMapper();
    }

    @Override
    void fillStatementWithColumnsData(User entity) throws SQLException {
        super.preparedStatement.setString(1, entity.getLogin());
        super.preparedStatement.setString(2, entity.getFirstName());
        super.preparedStatement.setString(3, entity.getLastName());
        super.preparedStatement.setString(4, entity.getEmail());
        super.preparedStatement.setInt(5, entity.getRole().getId());
        super.preparedStatement.setInt(6, entity.getHashedPassword());
    }

    @Override
    void addPrimaryKeyToStatement(int queryKeyIndex, User entity) throws SQLException {
        super.preparedStatement.setString(queryKeyIndex, entity.getLogin());
    }
}
