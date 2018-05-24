package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.Artifact;
import com.codecool.queststore.specifications.ArtifactById;
import com.codecool.queststore.specifications.SqlSpecification;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ArtifactRepositoryTest {

    @Test
    void addEntity() throws PersistenceLayerException, SQLException {
        ArtifactRepository artifactRepository = new ArtifactRepository();

        Artifact expectedArtifact = new Artifact("Bug free day", "Today you're invincible", 500);
        artifactRepository.add(expectedArtifact);

        SqlSpecification getArtifactById = new ArtifactById(4);
        Artifact actualArtifact = artifactRepository.query(getArtifactById).get(0);

        assertAll(() -> {
            assertEquals(expectedArtifact.getName(), actualArtifact.getName());
            assertEquals(expectedArtifact.getDescription(), actualArtifact.getDescription());
            assertEquals(expectedArtifact.getPrice(), actualArtifact.getPrice());
        });
    }

    @Test
    void updateEntity() {
    }

    @Test
    void deleteEntity() {
    }
}