package com.annapanna.gissahundenbackend.controller;

import com.annapanna.gissahundenbackend.entity.Dog;
import com.annapanna.gissahundenbackend.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    /*@PostMapping("/dogs")
    public Dog saveDogs(@RequestBody Dog dog) {
        System.out.println("Received dog data: " + dog);
        return dogsService.saveDog(dog);
    }*/
    @PostMapping("/dogs")
    public Dog saveDogs(@RequestParam("image") MultipartFile image, @RequestParam("dog_name") String dogName,
                        @RequestParam("breed") String breed, @RequestParam("anecdote") String anecdote,
                        @RequestParam("alt_text") String altText) {
        try {
            byte[] imageBytes = image.getBytes(); // Get the image as bytes

            Dog dog = new Dog();
            dog.setDog_name(dogName);
            dog.setBreed(breed);
            dog.setAnecdote(anecdote);
            dog.setImage(imageBytes); // Save the image as bytes in the database
            dog.setAlt_text(altText);

            System.out.println("Received dog data: " + dog);
            return dogsService.saveDog(dog);
        } catch (IOException e) {
            throw new RuntimeException("Error while processing the image", e);
        }
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

