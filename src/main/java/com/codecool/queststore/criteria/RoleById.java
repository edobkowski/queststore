package com.codecool.queststore.criteria;

import java.sql.SQLException;

public class RoleById extends GetById {
    static {
        QUERY = "SELECT * FROM roles WHERE id=?";
    }

    public RoleById(int id) throws SQLException {
        super(id);
    }
}
