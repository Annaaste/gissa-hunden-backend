package com.annapanna.gissahundenbackend.controller;

import com.annapanna.gissahundenbackend.entity.User;
import com.annapanna.gissahundenbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.readAll();
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email); // Implement userService.findByEmail()

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/users/{id}/addDog/{dogId}")
    public ResponseEntity<User> addUserDog(@PathVariable Long id, @PathVariable Long dogId) {
        User user = userService.readUser(id);

        // Update the user's dogIds array
        user.getDogIds().add(dogId);
        User updatedUser = userService.saveUser(user);

        return ResponseEntity.ok(updatedUser);
    }

}
