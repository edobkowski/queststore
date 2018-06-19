package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.UserData;
import com.codecool.queststore.repositories.Repository;
import com.codecool.queststore.repositories.Repositories;
import com.codecool.queststore.repositories.RepositoryPool;
import com.codecool.queststore.repositories.PersistenceLayerException;

import com.codecool.queststore.entities.Mentor;
import com.codecool.queststore.entities.CodecoolClass;

import com.codecool.queststore.criteria.SqlCriteria;
import com.codecool.queststore.criteria.CodecoolClassByMentorLogin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MentorMapper implements Mapper {
    private static final RepositoryPool REPOSITORY_POOL = RepositoryPool.getInstance();

    @Override
    public Mentor map(ResultSet resultSet) throws SQLException, PersistenceLayerException {
        String login = resultSet.getString("login");

        Repository<CodecoolClass> classRepository = REPOSITORY_POOL.getRepository(Repositories.CODECOOL_CLASS);
        SqlCriteria getClassesByMentor = new CodecoolClassByMentorLogin(login);
        List<CodecoolClass> classes = classRepository.query(getClassesByMentor);

        return new Mentor(new UserData(login), classes);
    }
}
