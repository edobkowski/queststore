package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

public class RoleById extends GetById {
    static {
        QUERY = "SELECT * FROM roles WHERE id=?";
    }

    public RoleById(int id) throws PersistenceLayerException {
        super(id);
    }
}
