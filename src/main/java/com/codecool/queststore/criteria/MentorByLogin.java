package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

public class MentorByLogin extends GetByLogin {
    static {
        QUERY = "SELECT * FROM mentors WHERE login=?";
    }

    public MentorByLogin(String login) throws PersistenceLayerException {
        super(login);
    }
}
