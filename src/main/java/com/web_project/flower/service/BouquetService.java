package com.web_project.flower.service;

import com.web_project.flower.model.BouquetModel;

import java.util.List;
import java.util.UUID;

public interface BouquetService {

    public List<BouquetModel> findAllBouquets();

    public BouquetModel findBouquetById(UUID id);

    public BouquetModel addBouquet(BouquetModel bouquet);

    public BouquetModel updateBouquet(BouquetModel bouquet);

    public void deleteBouquet(UUID id);
}
