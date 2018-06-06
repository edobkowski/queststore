package com.codecool.queststore.model.entities;

public class CodecoolClass {
    private int id;
    private String name;

    public CodecoolClass(String name) {
        this.name = name;
    }

    public CodecoolClass(int id, String name) {
        this(name);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
