package com.web_project.flower.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue
    private UUID Id;
    @Size(min = 3, message = "Адресс не менее 3 символов")
    private String Address;


    @ManyToOne
    @JoinColumn(name = "bouquetClient_id")
    private BouquetClientModel bouquetClient;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<DeliverieModel> deliveries;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<PaymentModel> payments;

    public OrderModel(){}

    public OrderModel(UUID id, String address, BouquetClientModel bouquetClient, ClientModel client, List<DeliverieModel> deliveries, List<PaymentModel> payments) {
        Id = id;
        Address = address;
        this.bouquetClient = bouquetClient;
        this.client = client;
        this.deliveries = deliveries;
        this.payments = payments;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public @Size(min = 3, message = "Адресс не менее 3 символов") String getAddress() {
        return Address;
    }

    public void setAddress(@Size(min = 3, message = "Адресс не менее 3 символов") String address) {
        Address = address;
    }

    public BouquetClientModel getBouquetClient() {
        return bouquetClient;
    }

    public void setBouquetClient(BouquetClientModel bouquetClient) {
        this.bouquetClient = bouquetClient;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public List<DeliverieModel> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<DeliverieModel> deliveries) {
        this.deliveries = deliveries;
    }

    public List<PaymentModel> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentModel> payments) {
        this.payments = payments;
    }
}
