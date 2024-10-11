package com.web_project.flower.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "deliveries")
public class DeliverieModel {
    @Id
    @GeneratedValue
    private UUID Id;
    @Size(min = 6, message = "Имя не менее 6 символов")
    private String Date;
    @Nullable
    private String Status;


    @ManyToOne
    @JoinColumn(name = "courier_id")
    private CourierModel courier;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel order;


    public DeliverieModel(){}


    public DeliverieModel(UUID id, String date, @Nullable String status, CourierModel courier, OrderModel order) {
        Id = id;
        Date = date;
        Status = status;
        this.courier = courier;
        this.order = order;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public @Size(min = 6, message = "Имя не менее 6 символов") String getDate() {
        return Date;
    }

    public void setDate(@Size(min = 6, message = "Имя не менее 6 символов") String date) {
        Date = date;
    }

    @Nullable
    public String getStatus() {
        return Status;
    }

    public void setStatus(@Nullable String status) {
        Status = status;
    }

    public CourierModel getCourier() {
        return courier;
    }

    public void setCourier(CourierModel courier) {
        this.courier = courier;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }
}
