package com.codecool.queststore.repositories;

import com.codecool.queststore.specifications.SqlSpecification;

import java.util.List;

public interface Repository<E> {
    void add(E entity) throws PersistenceLayerException;
    void update(E entity) throws PersistenceLayerException;
    void delete(E entity) throws PersistenceLayerException;
    List<E> query(SqlSpecification sqlSpecification) throws PersistenceLayerException;
}
