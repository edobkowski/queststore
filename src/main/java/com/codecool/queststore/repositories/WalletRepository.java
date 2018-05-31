package com.codecool.queststore.repositories;

import com.codecool.queststore.mappers.WalletMapper;
import com.codecool.queststore.model.entities.Wallet;

import java.sql.SQLException;

public class WalletRepository extends AbstractRepository<Wallet> {
    public WalletRepository() throws PersistenceLayerException {
        super.mapper = new WalletMapper();
    }

    @Override
    void addEntity(Wallet entity) throws SQLException {

    }

    @Override
    void updateEntity(Wallet entity) throws SQLException {

    }

    @Override
    void deleteEntity(Wallet entity) throws SQLException {

    }
}
