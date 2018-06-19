package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

public class CodecoolClassByMentorLogin extends GetByLogin {
    static {
        QUERY = "SELECT * FROM class_mentors WHERE mentor_login=?";
    }

    public CodecoolClassByMentorLogin(String login) throws PersistenceLayerException {
        super(login);
    }
}
