package com.codecool.queststore.mappers;

import com.codecool.queststore.model.entities.Wallet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletMapper implements Mapper {
    @Override
    public Wallet map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int balance = resultSet.getInt("balance");

        return new Wallet(id, balance);
    }
}
