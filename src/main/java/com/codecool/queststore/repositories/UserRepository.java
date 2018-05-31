package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.User;

import java.sql.SQLException;

public class UserRepository extends AbstractRepository<User> {
    public UserRepository() throws PersistenceLayerException {}

    @Override
    void addEntity(User entity) throws SQLException {

    }

    @Override
    void updateEntity(User entity) throws SQLException {

    }

    @Override
    void deleteEntity(User entity) throws SQLException {

    }
}
