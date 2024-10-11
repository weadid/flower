package com.web_project.flower.service;

import com.web_project.flower.model.ClientModel;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    public List<ClientModel> findAllClients();

    public ClientModel findClientById(UUID id);

    public ClientModel addClient(ClientModel client);

    public ClientModel updateClient(ClientModel client);

    public void deleteClient(UUID id);
}
