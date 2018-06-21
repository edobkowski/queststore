package com.codecool.queststore.services;

import com.codecool.queststore.criteria.SqlCriteria;
import com.codecool.queststore.repositories.PersistenceLayerException;
import com.codecool.queststore.repositories.RepositoryPool;

public class ShopManager {
    private static final RepositoryPool REPOSITORY_POOL;

    static {
        REPOSITORY_POOL = RepositoryPool.getInstance();
    }

    public void buyArtifact(int login, int artifactId) throws ServiceLayerException {

        try {
            //TODO edit student-artifact table
            throw new PersistenceLayerException("todo");

        } catch (PersistenceLayerException e) {

            throw new ServiceLayerException(String.format("Can't buy artifact (login: %s): %s", login, e.getMessage()));
        }
    }

}
