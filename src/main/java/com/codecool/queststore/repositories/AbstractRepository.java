package com.codecool.queststore.repositories;

import com.codecool.queststore.ConnectionProvider;
import com.codecool.queststore.criteria.SqlCriteria;
import com.codecool.queststore.mappers.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractRepository<E> implements Repository<E> {
    protected final Connection dbConnection;
    protected PreparedStatement preparedStatement;
    protected Mapper<E> mapper;

    public AbstractRepository() throws PersistenceLayerException {
        this.dbConnection = ConnectionProvider.getConnection();
    }

    abstract void addEntity(E entity) throws SQLException;

    @Override
    public void add(E entity) throws PersistenceLayerException {
        try {
            addEntity(entity);
        } catch (SQLException e) {
            throw new PersistenceLayerException("Can't add object to the database");
        }
    }

    abstract void updateEntity(E entity) throws SQLException;

    @Override
    public void update(E entity) throws PersistenceLayerException {
        try {
            updateEntity(entity);
        } catch (SQLException e) {
            throw new PersistenceLayerException("Can't edit object in the database");
        }
    }

    abstract void deleteEntity(E entity) throws SQLException;

    @Override
    public void delete(E entity) throws PersistenceLayerException {
        try {
            deleteEntity(entity);
        } catch (SQLException e) {
            throw new PersistenceLayerException("Can't remove object from the database");
        }
    }

    @Override
    public List<E> query(SqlCriteria sqlCriteria) throws PersistenceLayerException {
        List<E> entities = new ArrayList<>();

        try {
            ResultSet resultSet = sqlCriteria.toPreparedStatement().executeQuery();
            while (resultSet.next()) {
                entities.add(mapper.map(resultSet));
            }
            return entities;
        } catch (SQLException e) {
            throw new PersistenceLayerException("Cannot perform this query");
        }
    }
}
