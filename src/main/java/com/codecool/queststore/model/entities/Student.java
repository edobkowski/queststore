package com.codecool.queststore.model.entities;

public class Student {
    private String login;
    private int experience;
    private int walletId;
    private int classId;

    public Student(String login, int walletId) {
        this.login = login;
        this.experience = 0;
        this.walletId = walletId;
    }
    public Student(String login, int walletId, int classId) {
        this(login, walletId);
        this.classId = classId;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void addExperience(int experienceToAdd) {
        this.experience += experienceToAdd;
    }

    public int getWalletId() {
        return this.walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
