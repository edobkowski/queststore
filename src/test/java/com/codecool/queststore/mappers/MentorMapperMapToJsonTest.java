package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.Mentor;
import com.codecool.queststore.entities.UserData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MentorMapperMapToJsonTest {

    private static MentorMapper mentorMapper;
    private static Mentor mentorTest;

    @BeforeAll
    public static void setUp() {
        mentorMapper = new MentorMapper();
        UserData mentorUserData = new UserData("mentorTest");
        mentorTest = new Mentor(mentorUserData);
    }

    @Test
    @DisplayName("Check data after using mapToJson method with one mentor")
    public void testMapToJsonSendOneMentor() {
        String expected = "{\"login\": \"mentorTest\", \"first_name\": \"null\", \"last_name\": \"null\", " +
                "\"email\": \"null\", \"classes\": []}";

        String methodResult = mentorMapper.mapToJson(mentorTest);
        assertEquals(expected, methodResult);
    }

}