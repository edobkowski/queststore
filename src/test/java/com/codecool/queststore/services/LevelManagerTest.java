package com.codecool.queststore.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelManagerTest {

    @Test
    void testGetWithInvalidIndex() throws ServiceLayerException {
        int expectedSize = 0;
        int actualSize = new LevelManager().get(-1).size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void testEditWithInvalidIndex() {
        assertThrows(ServiceLayerException.class, () -> new LevelManager().edit(-1, "custom", 1));
    }

    @Test
    void testRemoveWithInvalidIndex() {
        assertThrows(ServiceLayerException.class, () -> new LevelManager().remove(-1));
    }
}