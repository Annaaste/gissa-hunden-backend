package com.annapanna.gissahundenbackend.service;

import com.annapanna.gissahundenbackend.entity.Dog;
import com.annapanna.gissahundenbackend.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DogServiceImpl implements DogsService{
    @Autowired
    private DogRepository dogRepository;
    @Override
    public List<Dog> readAll() {
        return dogRepository.findAll();
    }

    @Override
    public Dog saveDog(Dog dog) {
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

