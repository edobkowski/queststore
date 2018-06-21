package com.codecool.queststore.mappers;

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
import java.util.List;

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

        return new Student(login, experience, wallet, codecoolClass);
    }

    public String mapToJson(Student student) {

        CodecoolClass codecoolClass = student.getCodecoolClass();
        Wallet wallet = student.getWallet();
        WalletMapper walletMapper = new WalletMapper();
        CodecoolClassMapper codecoolClassMapper = new CodecoolClassMapper();

        String codecoolClassJson = codecoolClassMapper.mapToJson(codecoolClass);
        String walletJson = walletMapper.mapToJson(wallet);

        return String.format("{\"login\": \"%s\", \"fistname\": \"%s\", \"lastname\": \"%s\", \"email\": \"%s\", \"class\": \"%s\"}",
                student.getUserData().getLogin(),
                student.getUserData().getFirstName(),
                student.getUserData().getLastName(),
                student.getUserData().getEmail(),
                walletJson,
                codecoolClassJson);
    }

    public String mapToJson(List<Student> students) {
        StringBuilder json = new StringBuilder();

        json.append("{\"students\": [");

        int indexOfLastElement = students.size() - 1;
        for (Student student: students) {
            json.append(mapToJson(student));

            if (students.indexOf(student) != indexOfLastElement) {
                json.append(",");
            }
        }

        json.append("]}");

        return json.toString();
    }
}
