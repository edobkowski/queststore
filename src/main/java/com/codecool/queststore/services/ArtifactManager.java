package com.codecool.queststore.services;

import com.codecool.queststore.criteria.AllArtifacts;
import com.codecool.queststore.criteria.AllQuests;
import com.codecool.queststore.criteria.ArtifactById;
import com.codecool.queststore.criteria.QuestById;
import com.codecool.queststore.entities.Artifact;
import com.codecool.queststore.repositories.*;

import java.util.List;

public class ArtifactManager {
    private static final RepositoryPool REPOSITORY_POOL;

    static {
        REPOSITORY_POOL = RepositoryPool.getInstance();
    }

    public List<Artifact> getAll() throws ServiceLayerException {

        try {

            Repository<Artifact> artifactRepository = (ArtifactRepository)REPOSITORY_POOL.getRepository(Repositories.ARTIFACT);
            List<Artifact> artifacts = artifactRepository.query(new AllArtifacts());

            return artifacts;

        } catch(PersistenceLayerException e) {
            throw new ServiceLayerException("Can't get artifacts: " + e.getMessage());
        }
    }

    public void create(String name, String description, int price) throws ServiceLayerException {

        try {

            Artifact artifact = new Artifact(name, description, price);
            Repository<Artifact> artifactRepository = (ArtifactRepository)REPOSITORY_POOL.getRepository(Repositories.ARTIFACT);
            artifactRepository.add(artifact);

        } catch (PersistenceLayerException e) {

            throw new ServiceLayerException("Can't create artifact: " + e.getMessage());
        }
    }

    public void edit(int id, String name, String description, int price) throws ServiceLayerException {

        try {

            Repository<Artifact> artifactRepository = (ArtifactRepository)REPOSITORY_POOL.getRepository(Repositories.ARTIFACT);
            Artifact artifact = artifactRepository.query(new ArtifactById(id)).get(0);

            artifact.setName(name);
            artifact.setDescription(description);
            artifact.setPrice(price);

        } catch (PersistenceLayerException e) {

            throw new ServiceLayerException("Can't edit artifact: " + e.getMessage());
        }
    }

    public void delete(int id) throws ServiceLayerException {

        try {

            Repository<Artifact> artifactRepository = (ArtifactRepository)REPOSITORY_POOL.getRepository(Repositories.ARTIFACT);
            Artifact artifact = artifactRepository.query(new ArtifactById(id)).get(0);
            artifactRepository.delete(artifact);

        } catch (PersistenceLayerException e) {

            throw new ServiceLayerException("Can't delete artifact: " + e.getMessage());
        }
    }
}
