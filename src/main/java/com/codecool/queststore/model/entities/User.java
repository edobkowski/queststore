package com.codecool.queststore.model.entities;

public class User {
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private int roleId;
    private int hashedPassword;

    public User(String login, String firstName, String lastName, String email, int roleId, String password) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleId = roleId;
        this.hashedPassword = password.hashCode();
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPassword() {
        return this.hashedPassword;
    }

    public void setHashedPassword(int hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setPassword(String password) {
        this.hashedPassword = password.hashCode();
    }
}
