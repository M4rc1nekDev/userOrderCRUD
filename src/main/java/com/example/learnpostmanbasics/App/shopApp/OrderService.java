package com.example.learnpostmanbasics.App.shopApp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService {


    private final OrderRepository orderRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrdersById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public Optional<Order> updateOrder(Long id, OrderDTO orderDTO ) {
        return orderRepository.findById(id)
                .map(order -> {
                   if(orderDTO.item() != null && !orderDTO.item().isEmpty()) order.setItem(orderDTO.item());
                   if(orderDTO.price() > 0) order.setPrice(orderDTO.price());
                   if (orderDTO.quantity() > 0) order.setQuantity(orderDTO.quantity());
                   return orderRepository.save(order);
                });
    }



    public Order addOrderForUser(UserShop userShop, Order order) {
        if(userShop != null) order.setUserShop(userShop);
        return  orderRepository.save(order);
    }


    public Optional<Order> getOrderForUserById(UserShop userShop, Long OrderId) {
        return orderRepository.findById(OrderId)
                .filter(order -> order.getUserShop() != null && order.getUserShop().getId().equals(userShop.getId()));
    }





}
