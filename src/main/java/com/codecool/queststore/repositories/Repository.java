package com.codecool.queststore.repositories;

import com.codecool.queststore.specifications.SqlSpecification;

import java.util.List;

public interface Repository<E> {
    void add(E entity);
    void update(E entity);
    void delete(E entity);
    List<E> query(SqlSpecification sqlSpecification);
}
