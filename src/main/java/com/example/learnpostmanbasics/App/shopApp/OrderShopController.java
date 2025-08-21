package com.example.learnpostmanbasics.App.shopApp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class OrderShopController {
    private final OrderService orderService;




    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrdersById(id);
    }

    @GetMapping("/users/{usersId}/orders")
    public Optional<Order> getOrderForUser(@RequestBody UserShop userShop, @PathVariable Long usersId) {
        return orderService.getOrderForUserById(userShop, usersId);
    }



    @PostMapping("/orders")
    public Order addOrder(@RequestBody UserShop userShop, Order order) {
        return orderService.addOrderForUser(userShop, order);
    }


    @PostMapping("/users/{userShopId}/orders")
    public Order addOrderForUser(@PathVariable UserShop userShopId, @RequestBody Order order) {
        return orderService.addOrderForUser(userShopId, order);
    }  // Ten endpoint niestety nie dziala, chat mowi ze trzeba uzyc RuntimeException ale tego jeszcze nie przerabialem wiec zostawilem ;d


    @PutMapping("/orders/{id}")
    public Optional<Order> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(id, orderDTO);
    }

    @DeleteMapping("orders/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }






}
