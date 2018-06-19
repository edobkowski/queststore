package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

public class StudentByLogin extends GetByLogin {
    static {
        QUERY = "SELECT * FROM students WHERE login=?";
    }

    public StudentByLogin(String login) throws PersistenceLayerException {
        super(login);
    }
}
