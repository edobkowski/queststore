package com.codecool.queststore.criteria;

import java.sql.SQLException;

public class CodecoolClassByMentorLogin extends GetByLogin {
    static {
        QUERY = "SELECT * FROM class_mentors WHERE mentor_login=?";
    }

    public CodecoolClassByMentorLogin(String login) throws SQLException {
        super(login);
    }
}
