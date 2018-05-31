package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Wallet;
import com.codecool.queststore.specifications.SqlSpecification;

import java.sql.SQLException;
import java.util.List;

public class WalletRepository extends AbstractRepository<Wallet> {
    public WalletRepository() throws PersistenceLayerException {}

    @Override
    void addEntity(Wallet entity) throws SQLException {

    }

    @Override
    void updateEntity(Wallet entity) throws SQLException {

    }

    @Override
    void deleteEntity(Wallet entity) throws SQLException {

    }

    @Override
    List<Wallet> deserializeEntities() throws SQLException {
        return null;
    }
}
