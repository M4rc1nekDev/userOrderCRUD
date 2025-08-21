package com.example.learnpostmanbasics.App.shopApp;

import com.example.learnpostmanbasics.App.userApp.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserShopController {

    private final UserShopService userShopService;
    private final UserShopRepository userShopRepository;


    @GetMapping("/users-shop")
    public List<UserShop> getUser() {
        return userShopService.getAllUsers();
    }

    @GetMapping("/users-shop/{id}")
    public Optional<UserShop> getUserById(@PathVariable Long id) {
        return userShopService.getUserById(id);
    }

    @PostMapping("/users-shop")
    public UserShop addUser(@RequestBody UserShop userShop){
        return userShopService.addUser(userShop);
    }

    @PutMapping("/users-shop/{id}")
    public Optional<UserShop> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userShopService.updateUser(id, userDTO);
    }

    @DeleteMapping("/users-shop/{id}")
    public void deleteUser(@PathVariable Long id){
        userShopService.deleteUserById(id);
    }








}
