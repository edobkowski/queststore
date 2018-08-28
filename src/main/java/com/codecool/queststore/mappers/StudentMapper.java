package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.UserData;
import com.codecool.queststore.repositories.Repository;
import com.codecool.queststore.repositories.Repositories;
import com.codecool.queststore.repositories.RepositoryPool;

import com.codecool.queststore.entities.Student;
import com.codecool.queststore.entities.CodecoolClass;
import com.codecool.queststore.entities.Wallet;

import com.codecool.queststore.criteria.SqlCriteria;
import com.codecool.queststore.criteria.WalletById;
import com.codecool.queststore.criteria.CodecoolClassById;

import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements Mapper {
    private static final RepositoryPool REPOSITORY_POOL = RepositoryPool.getInstance();

    @Override
    public Student map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
        String login = resultSet.getString("login");
        int experience = resultSet.getInt("exp");

        Repository<Wallet> walletRepository = REPOSITORY_POOL.getRepository(Repositories.WALLET);
        SqlCriteria getWalletById = new WalletById(resultSet.getInt("wallet_id"));
        Wallet wallet = walletRepository.query(getWalletById).get(0);

        Repository<CodecoolClass> classRepository = REPOSITORY_POOL.getRepository(Repositories.CODECOOL_CLASS);
        SqlCriteria getClassById = new CodecoolClassById(resultSet.getInt("class_id"));
        CodecoolClass codecoolClass = classRepository.query(getClassById).get(0);

        return new Student(new UserData(login), experience, wallet, codecoolClass);
    }
}
