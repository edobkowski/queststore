package com.codecool.queststore.repositories;

import com.codecool.queststore.mappers.MentorMapper;
import com.codecool.queststore.model.entities.Mentor;

import java.sql.SQLException;

public class MentorRepository extends AbstractRepository<Mentor> {
    public MentorRepository() throws PersistenceLayerException {
        super.mapper = new MentorMapper();
    }

    @Override
    void addEntity(Mentor entity) throws SQLException {

    }

    @Override
    void updateEntity(Mentor entity) throws SQLException {

    }

    @Override
    void deleteEntity(Mentor entity) throws SQLException {

    }
}
