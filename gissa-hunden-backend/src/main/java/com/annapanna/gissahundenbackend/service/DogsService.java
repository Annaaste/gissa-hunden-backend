package com.annapanna.gissahundenbackend.service;

import com.annapanna.gissahundenbackend.entity.Dog;

import java.util.List;

public interface DogsService {

    List<Dog> readAll();

    Dog saveDog(Dog dog, Long userId);

    Dog readDog(Long id);

    void removeDog(Long id);

}
