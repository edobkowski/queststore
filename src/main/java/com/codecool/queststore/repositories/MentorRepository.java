package com.codecool.queststore.repositories;

import com.codecool.queststore.mappers.MentorMapper;
import com.codecool.queststore.model.entities.Mentor;

import java.sql.SQLException;

public class MentorRepository extends AbstractRepository<Mentor> {
    static {
        ADD_QUERY = "";
        EDIT_QUERY = "";
        DELETE_QUERY = "";
        EDIT_QUERY_KEY_INDEX = 0;
    }

    public MentorRepository() throws PersistenceLayerException {
        super.mapper = new MentorMapper();
    }

    @Override
    void fillStatementWithColumnsData(Mentor entity) throws SQLException {

    }

    @Override
    void addPrimaryKeyToStatement(int queryKeyIndex, Mentor entity) throws SQLException {

    }
}
