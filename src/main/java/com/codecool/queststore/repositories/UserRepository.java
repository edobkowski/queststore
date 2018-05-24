package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.User;
import com.codecool.queststore.specifications.RoleById;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractRepository<User> {
    public UserRepository() throws PersistenceLayerException {}

    private static final String ADD_QUERY = "INSERT INTO users(login, first_name, last_name, email, role_id, password)" +
                                            " VALUES(?,?,?,?,?,?)";
    private static final String EDIT_QUERY = ADD_QUERY + " WHERE login=?";
    private static final String DELETE_QUERY = "DELETE * FROM users WHERE login=?";

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
    } te

    @Override
    List<User> deserializeEntities() throws PersistenceLayerException {
        List<User> users = new ArrayList<>();

        try {
            while (super.resultSet.next()) {
                String login = super.resultSet.getString("login");
                String firstName = super.resultSet.getString("first_name");
                String lastName = super.resultSet.getString("last_name");
                String email = super.resultSet.getString("email");

                Repository roleRepository = this.REPOSITORY_POOL.getRepository(Repositories.ROLE);
                SqlSpecification getRoleById = new RoleById(super.resultSet.getInt("role_id"));
                Role role = roleRepository.query(getRoleById);

                String hashedPassword = super.resultSet.getString("password");

                users.add(new User(login, firstName, lastName, email, role, hashedPassword));
            }
            return users;
        } catch (SQLException e) {
            throw new PersistenceLayerException("Can't get User from the database");
        }
    }
}
