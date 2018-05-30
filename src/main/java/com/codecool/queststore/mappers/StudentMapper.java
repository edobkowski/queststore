package com.codecool.queststore.mappers;

import com.codecool.queststore.model.entities.Student;
import com.codecool.queststore.model.entities.CodecoolClass;
import com.codecool.queststore.model.entities.Wallet;
import com.codecool.queststore.specifications.SqlSpecification;
import com.codecool.queststore.repositories.Repository;
import com.codecool.queststore.repositories.Repositories;
import com.codecool.queststore.repositories.RepositoryPool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements Mapper {
    @Override
    public Student map(ResultSet resultSet) throws SQLException {
        String login = resultSet.getString("login");
        int experience = resultSet.getInt("exp");


        Repository<Wallet> walletRepository = REPOSITORY_POOL.getRepository(Repositories.WALLET);
        SqlSpecification getWalletById = new WalletById(resultSet.getInt("wallet_id"));
        Wallet wallet = walletRepository.query(getWalletById).get(0);

        Repository<CodecoolClass> classRepository = REPOSITORY_POOL.getRepository(Repositories.CODECOOL_CLASS);
        SqlSpecification getClassById = new ClassById(resultSet.getInt("class_id"));
        CodecoolClass codecoolClass = classRepository.query(getClassById).get(0);

        return new Student(login, experience, wallet, codecoolClass);
    }
}
