package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.CodecoolClass;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.List;

public class CodecoolClassRepository extends AbstractRepository<CodecoolClass> {
    public CodecoolClassRepository() throws PersistenceLayerException {}

    @Override
    void addEntity(CodecoolClass entity) throws SQLException {

    }

    @Override
    void updateEntity(CodecoolClass entity) throws SQLException {

    }

    @Override
    void deleteEntity(CodecoolClass entity) throws SQLException {

    }

    @Override
    List<CodecoolClass> queryEntities(SqlSpecification sqlSpecification) throws SQLException {
        return null;
    }
}