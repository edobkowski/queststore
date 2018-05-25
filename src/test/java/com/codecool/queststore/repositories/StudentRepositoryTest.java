package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Artifact;
import com.codecool.queststore.model.entities.CodecoolClass;
import com.codecool.queststore.model.entities.Student;
import com.codecool.queststore.model.entities.Wallet;
import com.codecool.queststore.specifications.CodecoolClassByName;
import com.codecool.queststore.specifications.LastCreatedWallet;
import com.codecool.queststore.specifications.SqlSpecification;
import com.codecool.queststore.specifications.StudentByLogin;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Test
    void addEntity() throws PersistenceLayerException, SQLException {
        RepositoryPool repositoryPool = new RepositoryPool();
        Repository<Student> studentRepository = repositoryPool.getRepository(Repositories.STUDENT);

        Wallet wallet = new Wallet();
        Repository<Wallet> walletRepository = repositoryPool.getRepository(Repositories.WALLET);
        walletRepository.add(wallet);
        int walletId = walletRepository.query(new LastCreatedWallet()).get(0).getId();

        CodecoolClass codecoolClass = new CodecoolClass("KRK.2017.11");
        Repository<CodecoolClass> codecoolClassRepository = repositoryPool.getRepository(Repositories.CODECOOL_CLASS);
        codecoolClassRepository.add(codecoolClass);
        int classId = codecoolClassRepository.query(new CodecoolClassByName(codecoolClass.getName())).get(0).getId();

        Student expectedStudent = new Student("jankowalski", wallet, codecoolClass);
        studentRepository.add(expectedStudent);

        SqlSpecification getStudentByLogin = new StudentByLogin("jankowalski");
        Student actualStudent = studentRepository.query(getStudentByLogin).get(0);

        assertAll(() -> {
            assertEquals(expectedStudent.getLogin(), actualStudent.getLogin());
            assertEquals(expectedStudent.getCodecoolClass().getId(), actualStudent.getCodecoolClass().getId());
            assertEquals(expectedStudent.getExperience(), actualStudent.getExperience());
            assertEquals(expectedStudent.getWallet().getId(), actualStudent.getWallet().getId());
        });
    }

    @Test
    void updateEntity() {
    }

    @Test
    void deleteEntity() {
    }

    @Test
    void deserializeEntities() {
    }
}