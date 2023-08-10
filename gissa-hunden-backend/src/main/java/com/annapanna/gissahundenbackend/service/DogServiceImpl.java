package com.annapanna.gissahundenbackend.service;

import com.annapanna.gissahundenbackend.entity.Dog;
import com.annapanna.gissahundenbackend.repository.DogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.annapanna.gissahundenbackend.entity.User;
import com.annapanna.gissahundenbackend.repository.UserRepository;


import java.util.List;
@Service
public class DogServiceImpl implements DogsService{
    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    @Override
    public List<Dog> readAll() {
        return dogRepository.findAll();
    }

    /*@Override
    public Dog saveDog(Dog dog) {
        return dogRepository.save(dog);
    }*/
   /* @Override

    public Dog saveDog(Dog dog) {
        // Get the currently authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Dog savedDog = dogRepository.save(dog);

        // Associate the user with the dog before saving
        user.getDogIds().add(savedDog.getId());
        userRepository.save(user);

        return dogRepository.save(dog);
    }*/

    @Override
    @Transactional
    public Dog saveDog(Dog dog, Long userId) {
        User user = userService.readUser(userId);
        user.getDogIds().add(dog.getId());

        dog.setUser(user);
        return dogRepository.save(dog);
    }

    @Override
    public Dog readDog(Long id) {
        return dogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dog is not present for this id: " + id));
    }

    @Override
    public void removeDog(Long id) {
        Dog existingDog = readDog(id);
        dogRepository.delete(existingDog);
    }

}

