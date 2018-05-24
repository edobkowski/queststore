package com.codecool.queststore.model.entities;

public class Student {
    private String login;
    private int experience;
    private Wallet wallet;
    private CodecoolClass codecoolClass;

    public Student(String login, Wallet wallet) {
        this.login = login;
        this.experience = 0;
        this.wallet = wallet;
    }
    public Student(String login, Wallet wallet, CodecoolClass codecoolClass) {
        this(login, wallet);
        this.codecoolClass = codecoolClass;
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

    public Wallet getWallet() {
        return this.wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public CodecoolClass getCodecoolClass() {
        return this.codecoolClass;
    }

    public void setCodecoolClass(CodecoolClass codecoolClass) {
        this.codecoolClass = codecoolClass;
    }
}
