package com.codecool.queststore.entities;

public class Wallet {
    private int id;
    private String ownerLogin;
    private int balance;

    public Wallet(String ownerLogin) {
        this.balance = 0;
        this.ownerLogin = ownerLogin;
    }

    public Wallet(int id, int balance) {
        this.id = id;
        this.balance = balance;
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
}
