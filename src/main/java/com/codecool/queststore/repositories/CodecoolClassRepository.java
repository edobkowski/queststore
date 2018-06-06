package com.codecool.queststore.repositories;

import com.codecool.queststore.mappers.CodecoolClassMapper;
import com.codecool.queststore.model.entities.CodecoolClass;

import java.sql.SQLException;

public class CodecoolClassRepository extends AbstractRepository<CodecoolClass> {
    static {
        ADD_QUERY = "";
        EDIT_QUERY = "";
        DELETE_QUERY = "";
        EDIT_QUERY_KEY_INDEX = 0;
    }

    public CodecoolClassRepository() throws PersistenceLayerException {
        super.mapper = new CodecoolClassMapper();
    }

    @Override
    void fillStatementWithColumnsData(CodecoolClass entity) throws SQLException {

    }

    @Override
    void addPrimaryKeyToStatement(int queryKeyIndex, CodecoolClass entity) throws SQLException {

    }
}