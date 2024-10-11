package com.web_project.flower.service;

import com.web_project.flower.model.ClientModel;
import com.web_project.flower.repository.ClientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InMemoryClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    public InMemoryClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }


    @Override
    public List<ClientModel> findAllClients() {
        return clientRepository.findAll(Sort.by("id"));
    }


    @Override
    public ClientModel findClientById(UUID id) {

        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public ClientModel addClient(ClientModel client) {

        return clientRepository.save(client);
    }

    @Override
    public ClientModel updateClient(ClientModel client) {
        if(clientRepository.existsById(client.getId())) {
            return clientRepository.save(client);
        }
        return null;
    }

    @Override
    public void deleteClient(UUID id) {
        if(clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        }
    }
}
