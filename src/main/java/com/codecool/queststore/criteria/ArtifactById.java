package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

public class ArtifactById extends GetById {
    static {
        QUERY = "SELECT * FROM artifacts WHERE id=?";
    }

    public ArtifactById(int id) throws PersistenceLayerException {
        super(id);
    }
}
