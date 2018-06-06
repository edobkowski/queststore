package com.codecool.queststore.repositories;

import com.codecool.queststore.mappers.QuestMapper;
import com.codecool.queststore.model.entities.Quest;

import java.sql.SQLException;

public class QuestRepository extends AbstractRepository<Quest> {
    static {
        ADD_QUERY = "";
        EDIT_QUERY = "";
        DELETE_QUERY = "";
        EDIT_QUERY_KEY_INDEX = 0;
    }

    public QuestRepository() throws PersistenceLayerException {
        super.mapper = new QuestMapper();
    }

    @Override
    void fillStatementWithColumnsData(Quest entity) throws SQLException {

    }

    @Override
    void addPrimaryKeyToStatement(int queryKeyIndex, Quest entity) throws SQLException {

    }
}
