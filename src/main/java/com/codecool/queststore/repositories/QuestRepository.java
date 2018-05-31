package com.codecool.queststore.repositories;

import com.codecool.queststore.mappers.QuestMapper;
import com.codecool.queststore.model.entities.Quest;

import java.sql.SQLException;

public class QuestRepository extends AbstractRepository<Quest> {
    public QuestRepository() throws PersistenceLayerException {
        super.mapper = new QuestMapper();
    }

    @Override
    void addEntity(Quest entity) throws SQLException {

    }

    @Override
    void updateEntity(Quest entity) throws SQLException {

    }

    @Override
    void deleteEntity(Quest entity) throws SQLException {

    }
}
