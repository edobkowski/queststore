package com.codecool.queststore.mappers;

import com.codecool.queststore.entities.Artifact;
import com.codecool.queststore.entities.Student;
import com.codecool.queststore.entities.UserData;
import com.codecool.queststore.entities.Wallet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentMapperMapToJsonTest {

    private static StudentMapper studentMapper;
    private static Student studentTest;
    private static Wallet wallet;

    @BeforeAll
    public static void setUp() {
        studentMapper = new StudentMapper();
        UserData studentUserData = new UserData("studentTest");
        List<Artifact> listArtifact = new ArrayList<>();
        Artifact artifact = new Artifact("artifact", "artifact", 1);
        listArtifact.add(artifact);
        wallet = new Wallet(1, "studentTest", 1, listArtifact);
        studentTest = new Student(studentUserData, wallet);

    }

    @Test
    @DisplayName("Check data after using mapToJson method with one student")
    public void testMapToJsonSendOneStudent() {

        String expected = "{\"login\": \"studentTest\", \"fistname\": \"null\", \"lastname\": " +
                "\"null\", \"email\": \"null\", \"class\": \"null\", \"wallet\": {\"id\": 1, " +
                "\"ownerLogin\": \"studentTest\", \"balance\": 1, \"artifacts\": [{\"id\": -1, " +
                "\"name\": \"artifact\", \"description\": \"artifact\", \"price\": 1}]}}";

        String methodResult = studentMapper.mapToJson(studentTest);
        assertEquals(expected, methodResult);
    }

}