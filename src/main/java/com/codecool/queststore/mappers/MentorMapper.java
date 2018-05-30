package com.codecool.queststore.mappers;

import com.codecool.queststore.model.entities.Mentor;
import com.codecool.queststore.model.entities.CodecoolClass;
import com.codecool.queststore.repositories.Repository;
import com.codecool.queststore.specifications.SqlSpecification;
import com.codecool.queststore.repositories.Repositories;
import com.codecool.queststore.repositories.RepositoryPool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MentorMapper implements Mapper {

    public static final RepositoryPool REPOSITORY_POOL = new RepositoryPool();

    @Override
    public Mentor map(ResultSet resultSet) throws SQLException {
        String login = resultSet.getString("login");

        Repository<CodecoolClass> classRepository = REPOSITORY_POOL.getRepository(Repositories.CODECOOL_CLASS);
        SqlSpecification getClassesByMentor = new ClassByMentor(login);
        List<CodecoolClass> classes = classRepository.query(getClassesByMentor);

        return new Mentor(login, classes);
    }
}
