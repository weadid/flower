package com.web_project.flower.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "payments")
public class PaymentModel {
    @Id
    @GeneratedValue
    private UUID Id;
    private String paymentDate;
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel order;

    public PaymentModel(){}

    public PaymentModel(UUID id, String paymentDate, String paymentMethod, OrderModel order) {
        Id = id;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.order = order;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }
}
