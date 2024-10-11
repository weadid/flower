package com.web_project.flower.service;

import com.web_project.flower.model.BouquetClientModel;

import java.util.List;
import java.util.UUID;

public interface BouquetClientService {

    public List<BouquetClientModel> findAllBouquetClients();

    public BouquetClientModel findBouquetClientById(UUID id);

    public BouquetClientModel addBouquetClient(BouquetClientModel bouquetClient);

    public BouquetClientModel updateBouquetClient(BouquetClientModel bouquetClient);

    public void deleteBouquetClient(UUID id);
}
