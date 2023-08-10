package com.annapanna.gissahundenbackend.service;

import com.annapanna.gissahundenbackend.entity.Dog;
import com.annapanna.gissahundenbackend.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    List<User> readAll();

    User readUser(Long id);

    List<Dog> getUserDogs(Long userId);

    User findByEmail(String email);

    User saveUser(User user);
}