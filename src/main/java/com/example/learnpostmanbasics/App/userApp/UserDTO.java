package com.example.learnpostmanbasics.App.userApp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

public record UserDTO(

        @Getter @Setter

        @NotBlank(message = "Imie nie moze byc puste")
        String name,

        @Email(message = "Email musi byc prawidlowy")
        String email,

        @Positive(message = "wiek musi byc dodatni")
        int age
) {}
