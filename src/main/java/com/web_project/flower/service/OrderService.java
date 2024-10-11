package com.web_project.flower.service;

import com.web_project.flower.model.OrderModel;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    public List<OrderModel> findAllOrders();

    public OrderModel findOrderById(UUID id);

    public OrderModel addOrder(OrderModel order);

    public OrderModel updateOrder(OrderModel order);

    public void deleteOrder(UUID id);
}
