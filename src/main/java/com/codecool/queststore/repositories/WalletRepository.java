package com.codecool.queststore.repositories;

import com.codecool.queststore.mappers.WalletMapper;
import com.codecool.queststore.model.entities.Wallet;

import java.sql.SQLException;

public class WalletRepository extends AbstractRepository<Wallet> {
    static {
        ADD_QUERY = "";
        EDIT_QUERY = "";
        DELETE_QUERY = "";
        EDIT_QUERY_KEY_INDEX = 0;
    }

    public WalletRepository() throws PersistenceLayerException {
        super.mapper = new WalletMapper();
    }

    @Override
    void fillStatementWithColumnsData(Wallet entity) throws SQLException {

    }

    @Override
    void addPrimaryKeyToStatement(int queryKeyIndex, Wallet entity) throws SQLException {

    }
}
