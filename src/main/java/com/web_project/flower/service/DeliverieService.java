package com.web_project.flower.service;

import com.web_project.flower.model.DeliverieModel;

import java.util.List;
import java.util.UUID;

public interface DeliverieService {

    public List<DeliverieModel> findAllDeliveries();

    public DeliverieModel findDeliverieById(UUID id);

    public DeliverieModel addDeliverie(DeliverieModel deliverie);

    public DeliverieModel updateDeliverie(DeliverieModel deliverie);

    public void deleteDeliverie(UUID id);
}
