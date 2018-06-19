package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

public class LevelById extends GetById {
    static {
        QUERY = "SELECT * FROM levels WHERE id=?";
    }

    public LevelById(int id) throws PersistenceLayerException {
        super(id);
    }
}
