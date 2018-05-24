package com.codecool.queststore.repositories;

public enum Repositories {
    USER(new UserRepository()),
    ROLE(new RoleRepository()),
    PRIVILEGE(new PrivilegeRepository()),
    MENTOR(new MentorRepository()),
    STUDENT(new StudentRepository()),
    CLASS(new CodecoolClassRepository()),
    QUEST(new QuestRepository()),
    ARTIFACT(new ArtifactRepository()),
    WALLET(new WalletRepository()),
    LEVEL(new LevelRepository());

    private Repository repository;

    Repositories(Repository repository) {
        this.repository = repository;
    }

    protected Repository getRepository() {
        return this.repository;
    }
}
