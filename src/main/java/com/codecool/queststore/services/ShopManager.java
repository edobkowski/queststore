package com.codecool.queststore.services;

import com.codecool.queststore.criteria.SqlCriteria;
import com.codecool.queststore.criteria.WalletArtifactsById;
import com.codecool.queststore.criteria.WalletByOwnerLogin;
import com.codecool.queststore.entities.Wallet;
import com.codecool.queststore.entities.WalletArtifacts;
import com.codecool.queststore.repositories.*;

public class ShopManager {
    private static final RepositoryPool REPOSITORY_POOL;

    static {
        REPOSITORY_POOL = RepositoryPool.getInstance();
    }

    public void buyArtifact(String login, int artifactId) throws ServiceLayerException {

        try {
            Repository<Wallet> walletRepository = (WalletRepository)REPOSITORY_POOL
                    .getRepository(Repositories.WALLET);
            Wallet wallet = walletRepository.query(new WalletByOwnerLogin(login)).get(0);
            int walletId = wallet.getId();

            Repository<WalletArtifacts> walletArtifactsRepository = (WalletArtifactsRepository)REPOSITORY_POOL
                    .getRepository(Repositories.WALLET_ARTIFACTS);
            WalletArtifacts walletArtifacts = walletArtifactsRepository
                    .query(new WalletArtifactsById(walletId, artifactId)).get(0);

            walletArtifacts.incrementQuantity();
            walletArtifactsRepository.update(walletArtifacts);

        } catch (PersistenceLayerException e) {

            throw new ServiceLayerException(String.format("Can't buy artifact (login: %s): %s", login, e.getMessage()));
        }
    }

}
