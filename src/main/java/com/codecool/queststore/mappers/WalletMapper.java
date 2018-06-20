package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.Artifact;
import com.codecool.queststore.entities.Wallet;
import com.codecool.queststore.repositories.PersistenceLayerException;
import com.codecool.queststore.criteria.ArtifactByWalletId;
import com.codecool.queststore.criteria.SqlCriteria;
import com.codecool.queststore.repositories.PersistenceLayerException;
import com.codecool.queststore.repositories.Repositories;
import com.codecool.queststore.repositories.Repository;
import com.codecool.queststore.repositories.RepositoryPool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WalletMapper implements Mapper {
    private static final RepositoryPool REPOSITORY_POOL = RepositoryPool.getInstance();

    @Override
    public Wallet map(ResultSet resultSet) throws SQLException, PersistenceLayerException {

        int id = resultSet.getInt("id");
        int balance = resultSet.getInt("balance");

        Repository<Artifact> artifactRepository = REPOSITORY_POOL.getRepository(Repositories.ARTIFACT);
        SqlCriteria getArtifactsByWalletId = new ArtifactByWalletId(id);

        List<Artifact> artifacts = artifactRepository.query(getArtifactsByWalletId);

        return new Wallet(id, balance, artifacts);
    }
}
