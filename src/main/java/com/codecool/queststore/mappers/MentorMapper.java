package com.codecool.queststore.mappers;

import com.codecool.queststore.model.entities.Mentor;
import com.codecool.queststore.model.entities.CodecoolClass;
import com.codecool.queststore.repositories.Repository;
import com.codecool.queststore.criteria.SqlCriteria;
import com.codecool.queststore.criteria.CodecoolClassByMentor;
import com.codecool.queststore.repositories.Repositories;
import com.codecool.queststore.repositories.RepositoryPool;
import com.codecool.queststore.repositories.PersistenceLayerException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MentorMapper implements Mapper {

    private static final RepositoryPool REPOSITORY_POOL = new RepositoryPool();

    @Override
    public Mentor map(ResultSet resultSet) throws SQLException, PersistanceLayerException {
        String login = resultSet.getString("login");

        Repository<CodecoolClass> classRepository = REPOSITORY_POOL.getRepository(Repositories.CODECOOL_CLASS);
        SqlCriteria getClassesByMentor = new CodecoolClassByMentorLogin(login);
        List<CodecoolClass> classes = classRepository.query(getClassesByMentor);

        return new Mentor(login, classes);
    }
}
