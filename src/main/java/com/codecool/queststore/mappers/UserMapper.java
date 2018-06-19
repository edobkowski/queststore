package com.codecool.queststore.mappers;

import com.codecool.queststore.criteria.RoleById;
import com.codecool.queststore.criteria.SqlCriteria;
import com.codecool.queststore.entities.Role;
import com.codecool.queststore.entities.User;
import com.codecool.queststore.repositories.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    private static final RepositoryPool REPOSITORY_POOL = RepositoryPool.getInstance();

    @Override
    public User map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
        String login = resultSet.getString("login");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String email = resultSet.getString("email");

        int role_id = resultSet.getInt("role_id");
        SqlCriteria getRoleById= new RoleById(role_id);
        Repository<Role> roleRepository = REPOSITORY_POOL.getRepository(Repositories.ROLE);
        Role role = roleRepository.query(getRoleById).get(0);

        int password = resultSet.getInt("password");

        return new User(login, firstName, lastName, email, role, password);
    }
}