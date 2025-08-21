package com.example.learnpostmanbasics.App.shopApp;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

public record OrderDTO(

        @Getter @Setter

        @NotBlank(message = "Przedmiot musi miec nazwe")
        String item,


        @Positive(message = "ilosc musi byc dodatnia")
        int quantity,


        @Positive(message = "Cena musi byc dodatnia")
        double price
) {}
