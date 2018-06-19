package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

public class CodecoolClassById extends GetById {
    static {
        QUERY = "SELECT * FROM classes WHERE id=?";
    }

    public CodecoolClassById(int id) throws PersistenceLayerException {
        super(id);
    }
}
