package com.codecool.queststore.criteria;

import java.sql.SQLException;

public class ArtifactById extends GetById {
    static {
        QUERY = "SELECT * FROM artifacts WHERE id=?";
    }

    public ArtifactById(int id) throws SQLException {
        super(id);
    }
}
