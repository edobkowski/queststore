package com.codecool.queststore.model.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtifactTest {
    @Test
    @DisplayName("Test 3 args constructor")
    public void test3argsConstructor() {
        Artifact artifact = new Artifact("Name", "Description", 300);

        assertAll(() -> {
            assertEquals("Name", artifact.getName());
            assertEquals("Description", artifact.getDescription());
            assertEquals(300, artifact.getPrice());
            assertEquals(0, artifact.getId());
        });
    }

    @Test
    @DisplayName("Test 4 args constructor")
    public void test4argsConstructor() {
        Artifact artifact = new Artifact(2137, "Name", "Description", 300);

        assertAll(() -> {
            assertEquals("Name", artifact.getName());
            assertEquals("Description", artifact.getDescription());
            assertEquals(300, artifact.getPrice());
            assertNotNull(artifact.getId());
            assertEquals(2137, artifact.getId());
        });
    }
}