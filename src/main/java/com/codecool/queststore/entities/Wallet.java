package com.codecool.queststore.entities;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private int id;
    private String ownerLogin;
    private int balance;
    private List<Artifact> artifactList;

    public Wallet(String ownerLogin) {
        this.balance = 0;
        this.ownerLogin = ownerLogin;
    }

    public Wallet(int id, int balance, List<Artifact> artifactList) {
        this.id = id;
        this.balance = balance;
        this.artifactList = artifactList;
    }

    public int getId() {
        return this.id;
    }

    public String getOwnerLogin() {
        return this.ownerLogin;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addBalance (int valueToAdd) {
        this.balance += valueToAdd;
    }

    public List<Artifact> getArtifactList() {
        return artifactList;
    }

    public void setArtifactList(List<Artifact> artifactList) {
        this.artifactList = artifactList;
    }
}
