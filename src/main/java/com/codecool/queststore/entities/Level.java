package com.codecool.queststore.entities;

public class Level {
    private int id;
    private String name;
    private int treshold;

    public Level(int id, String name, int treshold) {
        this.id = id;
        this.name = name;
        this.treshold = treshold;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTreshold() {
        return this.treshold;
    }

    public void setTreshold(int treshold) {
        this.treshold = treshold;
    }
}
