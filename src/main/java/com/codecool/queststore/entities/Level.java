package com.codecool.queststore.entities;

public class Level {

    private int id;
    private String name;
    private int treshold;

    Level(int id, String name, int treshold) {
       this.id = id;
       this.name = name;
       this.treshold = treshold;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTreshold() {
        return treshold;
    }

}
