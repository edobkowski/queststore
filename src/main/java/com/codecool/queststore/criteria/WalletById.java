package com.codecool.queststore.criteria;

import java.sql.SQLException;

public class WalletById extends GetById {
    static {
        QUERY = "SELECT * FROM wallets WHERE id=?";
    }

    public WalletById(int id) throws SQLException {
        super(id);
    }
}
