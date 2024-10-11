package com.web_project.flower.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class ClientModel {
    @Id
    @GeneratedValue
    private UUID Id;
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String Name;
    @Email(message = "Емеил не корректен")
    private String CorpEmail;
    @Nullable
    private String Phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<OrderModel> orders;

    public ClientModel(){}


    public ClientModel(UUID id, String name, String corpEmail, @Nullable String phone, List<OrderModel> orders) {
        Id = id;
        Name = name;
        CorpEmail = corpEmail;
        Phone = phone;
        this.orders = orders;
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

    public @Email(message = "Емеил не корректен") String getCorpEmail() {
        return CorpEmail;
    }

    public void setCorpEmail(@Email(message = "Емеил не корректен") String corpEmail) {
        CorpEmail = corpEmail;
    }

    @Nullable
    public String getPhone() {
        return Phone;
    }

    public void setPhone(@Nullable String phone) {
        Phone = phone;
    }

    public List<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }
}
