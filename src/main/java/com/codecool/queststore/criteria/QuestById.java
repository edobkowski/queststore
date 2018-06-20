package com.codecool.queststore.criteria;

import com.codecool.queststore.repositories.PersistenceLayerException;

public class QuestById extends GetById {
    static {
        QUERY = "SELECT * FROM quests WHERE id=?";
    }

    public QuestById(int id) throws PersistenceLayerException {
        super(id);
    }
}
