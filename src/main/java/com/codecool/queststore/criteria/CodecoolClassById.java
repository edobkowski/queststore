package com.codecool.queststore.criteria;

import java.sql.SQLException;

public class CodecoolClassById extends GetById {
    static {
        QUERY = "SELECT * FROM classes WHERE id=?";
    }

    public CodecoolClassById(int id) throws SQLException {
        super(id);
    }
}
