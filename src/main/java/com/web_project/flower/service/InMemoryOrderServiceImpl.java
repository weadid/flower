package com.web_project.flower.service;

import com.web_project.flower.model.OrderModel;
import com.web_project.flower.repository.OrderRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InMemoryOrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public InMemoryOrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    @Override
    public List<OrderModel> findAllOrders() {
        return orderRepository.findAll(Sort.by("id"));
    }


    @Override
    public OrderModel findOrderById(UUID id) {

        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public OrderModel addOrder(OrderModel order) {

        return orderRepository.save(order);
    }

    @Override
    public OrderModel updateOrder(OrderModel order) {
        if(orderRepository.existsById(order.getId())) {
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public void deleteOrder(UUID id) {
        if(orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        }
    }
}
