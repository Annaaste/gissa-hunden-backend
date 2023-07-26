package com.annapanna.gissahundenbackend.controller;

import com.annapanna.gissahundenbackend.entity.Dog;
import com.annapanna.gissahundenbackend.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class DogController {

    @Autowired
    private DogsService dogsService;

    @GetMapping("/dogs")
    public List<Dog> getDogs() {
        return dogsService.readAll();
    }

    @PostMapping("/dogs")
    public Dog saveDogs(@RequestBody Dog dog) {
        System.out.println("Received dog data: " + dog);
        return dogsService.saveDog(dog);
    }

    @GetMapping("/dogs/{id}")
    public Dog getDog(@PathVariable Long id) {
        return dogsService.readDog(id);
    }

    @DeleteMapping("/dogs/{id}")
    public ResponseEntity<HttpStatus> deleteDog(@PathVariable Long id) {
        dogsService.removeDog(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/dogs")
    public Dog updateDog(@RequestBody Dog updatedDog) {
        return dogsService.saveDog(updatedDog);
    }
}

