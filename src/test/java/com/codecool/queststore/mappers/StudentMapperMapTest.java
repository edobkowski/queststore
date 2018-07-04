package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.Student;
import com.codecool.queststore.entities.UserData;
import com.codecool.queststore.entities.Wallet;
import com.codecool.queststore.repositories.PersistenceLayerException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class StudentMapperMapTest {

    private static StudentMapper studentMapper;

    @BeforeAll
    public static void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    @DisplayName("Send null to map method in StudentMapper class")
    public void testMapSendNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            studentMapper.map(null);
        });
    }
}