package com.web_project.flower.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "couriers")
public class CourierModel {
    @Id
    @GeneratedValue
    private UUID Id;
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String Name;
    @Nullable
    private String Phone;

    @OneToMany(mappedBy = "courier", cascade = CascadeType.ALL)
    private List<DeliverieModel> deliveries;


    public CourierModel(){}


    public CourierModel(UUID id, String name, @Nullable String phone, List<DeliverieModel> deliveries) {
        Id = id;
        Name = name;
        Phone = phone;
        this.deliveries = deliveries;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getName() {
        return Name;
    }

    public void setName(@Size(min = 3, message = "Имя не менее 3 символов") String name) {
        Name = name;
    }

    @Nullable
    public String getPhone() {
        return Phone;
    }

    public void setPhone(@Nullable String phone) {
        Phone = phone;
    }

    public List<DeliverieModel> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<DeliverieModel> deliveries) {
        this.deliveries = deliveries;
    }
}
