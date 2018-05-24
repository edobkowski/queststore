package com.codecool.queststore.repositories;

import java.util.Map;
import java.util.HashMap;

public class RepositoryPool {
    private final Map<Repositories, Repository> repositories;

    public RepositoryPool() {
        this.repositories = new HashMap<>();
    }

    public Repository getRepository(Repositories repositoryType) {
        if (!this.repositories.containsKey(repositoryType)) {
            this.repositories.put(repositoryType, repositoryType.getRepository());
        }

        return this.repositories.get(repositoryType);
    }
}
