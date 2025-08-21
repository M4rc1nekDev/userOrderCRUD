package com.example.learnpostmanbasics.App.shopApp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;



public record UserShopDTO(

        @Getter @Setter

        @NotBlank(message = "Imie nie moze byc puste")
        String name,

        @Email(message = "Email musi być prawidlowy")
        String email,

        @Positive(message = "Wiek musi byc dodatni")
        int age

){}
