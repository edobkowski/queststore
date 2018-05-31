package com.codecool.queststore.repositories;

import com.codecool.queststore.mappers.StudentMapper;
import com.codecool.queststore.model.entities.Student;

import java.sql.SQLException;

public class StudentRepository extends AbstractRepository<Student> {
    private static final String ADD_QUERY = "INSERT INTO students(login, exp, wallet_id, class_id) VALUES(?,?,?,?)";
    private static final String EDIT_QUERY = ADD_QUERY + " WHERE login=?";
    private static final String DELETE_QUERY = "DELETE * FROM students WHERE login=?";

    public StudentRepository() throws PersistenceLayerException {
        super.mapper = new StudentMapper();
    }

    @Override
    void addEntity(Student entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(ADD_QUERY);
        super.preparedStatement.setString(1, entity.getLogin());
        super.preparedStatement.setInt(2, entity.getExperience());
        super.preparedStatement.setInt(3, entity.getWallet().getId());
        super.preparedStatement.setInt(4, entity.getCodecoolClass().getId());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void updateEntity(Student entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(EDIT_QUERY);
        super.preparedStatement.setString(1, entity.getLogin());
        super.preparedStatement.setInt(2, entity.getExperience());
        super.preparedStatement.setInt(3, entity.getWallet().getId());
        super.preparedStatement.setInt(4, entity.getCodecoolClass().getId());
        super.preparedStatement.setString(5, entity.getLogin());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void deleteEntity(Student entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(DELETE_QUERY);
        super.preparedStatement.setString(1, entity.getLogin());
        super.preparedStatement.executeUpdate();
    }
}
