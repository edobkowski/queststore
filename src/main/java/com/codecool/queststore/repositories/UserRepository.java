package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.User;

import java.sql.SQLException;

public class UserRepository extends AbstractRepository<User> {
    private static final String ADD_QUERY = "INSERT INTO users(login, first_name, last_name, email, role_id, password)" +
            " VALUES(?,?,?,?,?,?)";
    private static final String EDIT_QUERY = ADD_QUERY + " WHERE login=?";
    private static final String DELETE_QUERY = "DELETE * FROM users WHERE login=?";

    public UserRepository() throws PersistenceLayerException {}


    @Override
    void addEntity(User entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(ADD_QUERY);
        super.preparedStatement.setString(1, entity.getLogin());
        super.preparedStatement.setString(2, entity.getFirstName());
        super.preparedStatement.setString(3, entity.getLastName());
        super.preparedStatement.setString(4, entity.getEmail());
        super.preparedStatement.setInt(5, entity.getRole().getId());
        super.preparedStatement.setInt(6, entity.getHashedPassword());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void updateEntity(User entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(EDIT_QUERY);
        super.preparedStatement.setString(1, entity.getLogin());
        super.preparedStatement.setString(2, entity.getFirstName());
        super.preparedStatement.setString(3, entity.getLastName());
        super.preparedStatement.setString(4, entity.getEmail());
        super.preparedStatement.setInt(5, entity.getRole().getId());
        super.preparedStatement.setInt(6, entity.getHashedPassword());
        super.preparedStatement.setString(7, entity.getLogin());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void deleteEntity(User entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(DELETE_QUERY);
        super.preparedStatement.setString(1, entity.getLogin());
        super.preparedStatement.executeUpdate();
    }
}
