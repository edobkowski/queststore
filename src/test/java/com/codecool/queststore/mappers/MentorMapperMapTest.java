package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.Artifact;
import com.codecool.queststore.entities.Mentor;
import com.codecool.queststore.entities.UserData;
import com.codecool.queststore.repositories.PersistenceLayerException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MentorMapperMapTest {

    private static MentorMapper mentorMapper;

    @BeforeAll
    public static void setUp() {
        mentorMapper = new MentorMapper();
    }

    @Test
    @DisplayName("Send null to map method in MentorMapper class")
    public void testMapSendNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            mentorMapper.map(null);
        });
    }
}
