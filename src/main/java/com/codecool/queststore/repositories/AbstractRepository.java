package com.codecool.queststore.repositories;

import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.List;

public abstract class AbstractRepository<E> implements Repository<E> {
    protected final Connection dbConnection;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;

    public AbstractRepository() throws PersistenceLayerException {
        try {
            this.dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/queststore",
                    "postgres",
                    "postgres");
        } catch (SQLException e) {
            throw new PersistenceLayerException("Can't get connection to database");
        }
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
    public List<E> query(SqlSpecification sqlSpecification) throws PersistenceLayerException {
        try {
            this.resultSet = sqlSpecification.toQuery().executeQuery();
            return this.deserializeEntities();
        } catch (SQLException e) {
            throw new PersistenceLayerException("Cannot perform this action");
        }
    }

    abstract List<E> deserializeEntities() throws SQLException;
}
