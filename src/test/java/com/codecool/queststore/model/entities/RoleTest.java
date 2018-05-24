package com.codecool.queststore.model.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    @DisplayName("1 argument constructor test")
    public void OneArgConstructorTest() {
        Role role = new Role("user");

        assertAll(() -> {
            assertEquals(-1, role.getId());
            assertEquals("user", role.getName());
        });
    }

    @Test
    @DisplayName("2 arguments constructor test")
    public void TwoArgsConstructorTest() {
        Role role = new Role(213, "user");

        assertAll(() -> {
            assertEquals(213, role.getId());
            assertEquals("user", role.getName());
        });
    }
}