package com.codecool.queststore.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Mentor {
    private String login;
    private List<CodecoolClass> classes;

    public Mentor(String login) {
        this.login = login;
        this.classes = new ArrayList<>();
    }
    public Mentor(String login, List<CodecoolClass> classes) {
        this.login = login;
        this.classes = classes;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<CodecoolClass> getClasses() {
        return this.classes;
    }

    public void setClasses(List<CodecoolClass> classes) {
        this.classes = classes;
    }

    public void addClass(CodecoolClass newClass) {
        this.classes.add(newClass);
    }

    public void removeClass(CodecoolClass classToRemove) {
        this.classes.remove(classToRemove);
    }
}
