package com.codecool.queststore.model.entities;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrivilegeTest {

    @Test
    @DisplayName("1 argument constructor test")
    public void OneArgConstructorTest() {
        Privilege role = new Privilege("Creating mentor");

        assertAll(() -> {
            assertEquals(-1, role.getId());
            assertEquals("Creating mentor", role.getName());
        });
    }

    @Test
    @DisplayName("2 arguments constructor test")
    public void TwoArgsConstructorTest() {
        Role role = new Role(213, "Creating mentor");

        assertAll(() -> {
            assertEquals(213, role.getId());
            assertEquals("Creating mentor", role.getName());
        });
    }
}