package com.example.learnpostmanbasics.App.shopApp;

import com.example.learnpostmanbasics.App.userApp.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserShopService {

    private final UserShopRepository userShopRepository;

    public UserShop addUser(UserShop userShop) {
        return userShopRepository.save(userShop);
    }

    public List<UserShop> getAllUsers() {
        return userShopRepository.findAll();
    }

    public Optional<UserShop> getUserById(Long id) {
        return userShopRepository.findById(id);
    }


    public void deleteUserById(Long id) {
        userShopRepository.deleteById(id);
    }

    public Optional<UserShop> updateUser(Long id, UserDTO userDTO) {
        return userShopRepository.findById(id)
                .map(user ->{
                    if(userDTO.age() > 0) user.setAge(userDTO.age());
                    if(userDTO.name() != null && !userDTO.name().isEmpty()) user.setName(userDTO.name());
                    if(userDTO.email() != null && !userDTO.email().isEmpty()) user.setEmail(userDTO.email());
                    return userShopRepository.save(user);
                });
    }



}
