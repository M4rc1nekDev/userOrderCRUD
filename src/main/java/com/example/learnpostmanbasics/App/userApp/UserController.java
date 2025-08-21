package com.example.learnpostmanbasics.App.userApp;

import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;



    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/users/{id}")
    public Optional<User> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }




    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
