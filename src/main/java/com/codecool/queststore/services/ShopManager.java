package com.codecool.queststore.services;

import com.codecool.queststore.criteria.ArtifactById;
import com.codecool.queststore.criteria.SqlCriteria;
import com.codecool.queststore.criteria.WalletArtifactsById;
import com.codecool.queststore.criteria.WalletByOwnerLogin;
import com.codecool.queststore.entities.Artifact;
import com.codecool.queststore.entities.Wallet;
import com.codecool.queststore.entities.WalletArtifacts;
import com.codecool.queststore.repositories.*;

import java.util.List;

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
            int walletBalance = wallet.getBalance();
            int walletId = wallet.getId();

            Repository<Artifact> artifactRepository = (ArtifactRepository)REPOSITORY_POOL
                    .getRepository(Repositories.ARTIFACT);
            Artifact artifact = artifactRepository.query(new ArtifactById(artifactId)).get(0);
            int artifactPrice = artifact.getPrice();

            if(walletBalance < artifactPrice) {
                throw new PersistenceLayerException("No enough coolcoins!");
            }

            Repository<WalletArtifacts> walletArtifactsRepository = (WalletArtifactsRepository)REPOSITORY_POOL
                    .getRepository(Repositories.WALLET_ARTIFACTS);
            List<WalletArtifacts> walletArtifactsList = walletArtifactsRepository
                    .query(new WalletArtifactsById(walletId, artifactId));
            WalletArtifacts walletArtifacts = new WalletArtifacts(walletId, artifactId);

            if(walletArtifactsList.size() > 0) {
                walletArtifacts = walletArtifactsList.get(0);
            }

            walletArtifacts.incrementQuantity();

            if(walletArtifacts.getQuantity() == 1) {
                walletArtifactsRepository.add(walletArtifacts);
            } else {
                walletArtifactsRepository.update(walletArtifacts);
            }

        } catch (PersistenceLayerException e) {

            throw new ServiceLayerException(String.format("Can't buy artifact (login: %s): %s", login, e.getMessage()));
        }
    }

}
