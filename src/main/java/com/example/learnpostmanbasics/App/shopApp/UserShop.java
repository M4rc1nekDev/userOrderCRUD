package com.example.learnpostmanbasics.App.shopApp;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_shop")
@Getter @Setter
public class UserShop {


    @OneToMany(mappedBy = "userShop")
    private List<Order> orders;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String email;
    private int age;


}
