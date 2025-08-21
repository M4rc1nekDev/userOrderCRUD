package com.example.learnpostmanbasics.App.userApp;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {       // DODAWANIE UZYTKOWNIKA
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {       // WYSWIETLANIE WSZYSTKICH UZYTKOWNIKOW
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {    // WYSWIETLANIE UZYTKOWNIKOW PO ID
        return userRepository.findById(id);
    }

    public Optional<User> updateUser(Long id, UserDTO userDTO) {
        return userRepository.findById(id)
                .map( user -> {
                    if (userDTO.age() > 0) user.setAge(userDTO.age());
                    if (userDTO.name() != null && !userDTO.name().isEmpty()) user.setName(userDTO.name());
                    if (userDTO.email() != null && !userDTO.email().isEmpty()) user.setEmail(userDTO.email());
                    return userRepository.save(user);
                });
    }

    public void deleteUser(Long id) {         // USUWANIE UZYTKOWNIKOW PO ID
        userRepository.deleteById(id);
    }
}

