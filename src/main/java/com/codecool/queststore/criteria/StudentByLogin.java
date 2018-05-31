package com.codecool.queststore.criteria;

import java.sql.SQLException;

public class StudentByLogin extends GetByLogin {
    static {
        QUERY = "SELECT * FROM students WHERE login=?";
    }

    public StudentByLogin(String login) throws SQLException {
        super(login);
    }
}
