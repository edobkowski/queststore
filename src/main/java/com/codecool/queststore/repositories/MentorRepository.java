package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Mentor;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.List;

public class MentorRepository extends AbstractRepository<Mentor> {
    public MentorRepository() throws PersistenceLayerException {}

    @Override
    void addEntity(Mentor entity) throws SQLException {

    }

    @Override
    void updateEntity(Mentor entity) throws SQLException {

    }

    @Override
    void deleteEntity(Mentor entity) throws SQLException {

    }

    @Override
    List<Mentor> deserializeEntities() throws SQLException {
        return null;
    }
}
