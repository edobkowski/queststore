package com.codecool.queststore.criteria;


import com.codecool.queststore.repositories.PersistenceLayerException;

public class ArtifactByWalletId extends GetById {
    static {
        QUERY = "SELECT * FROM wallet_artifacts WHERE wallet_id=?";
    }

    public ArtifactByWalletId(int id) throws PersistenceLayerException {
        super(id);
    }
}
