package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Quest;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.List;

public class QuestRepository extends AbstractRepository<Quest> {
    public QuestRepository() throws PersistenceLayerException {}

    @Override
    void addEntity(Quest entity) throws SQLException {

    }

    @Override
    void updateEntity(Quest entity) throws SQLException {

    }

    @Override
    void deleteEntity(Quest entity) throws SQLException {

    }

    @Override
    List<Quest> queryEntities(SqlSpecification sqlSpecification) throws SQLException {
        return null;
    }
}
