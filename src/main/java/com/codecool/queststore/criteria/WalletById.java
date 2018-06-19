package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

public class WalletById extends GetById {
    static {
        QUERY = "SELECT * FROM wallets WHERE id=?";
    }

    public WalletById(int id) throws PersistenceLayerException {
        super(id);
    }
}
