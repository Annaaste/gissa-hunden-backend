package com.annapanna.gissahundenbackend.service;

import com.annapanna.gissahundenbackend.entity.Dog;
import com.annapanna.gissahundenbackend.entity.User;
import com.annapanna.gissahundenbackend.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.annapanna.gissahundenbackend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public User readUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User is not present for this id: " + id));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User is not present for this email: " + email));
    }

    @Override
    public List<Dog> getUserDogs(Long userId) {
        User user = readUser(userId);
        List<Long> dogIds = user.getDogIds();

        List<Dog> dogs = new ArrayList<>();
        for (Long dogId : dogIds) {
            dogRepository.findById(dogId).ifPresent(dogs::add);
        }

        return dogs;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}