package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Student;

import java.sql.SQLException;

public class StudentRepository extends AbstractRepository<Student> {
    public StudentRepository() throws PersistenceLayerException {}

    @Override
    void addEntity(Student entity) throws SQLException {

    }

    @Override
    void updateEntity(Student entity) throws SQLException {

    }

    @Override
    void deleteEntity(Student entity) throws SQLException {

    }
}
