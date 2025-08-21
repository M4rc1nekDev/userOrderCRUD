package com.example.learnpostmanbasics.App.shopApp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name= "my_order")
@Getter @Setter
public class Order {

    @ManyToOne
    @JoinColumn(name = "user_shop_id")
    private UserShop userShop;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private double price;
    private int quantity;

}
