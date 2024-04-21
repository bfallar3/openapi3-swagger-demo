package com.benjsoft.openapi.swagger.controller;

import com.benjsoft.openapi.swagger.entity.User;
import com.benjsoft.openapi.swagger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userRepository.findByUsername(username);

        if (user == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) throws URISyntaxException {
        User user = userRepository.findByUsername(newUser.getUsername());

        if(user != null) {
            return ResponseEntity.status(409).build();
        }

        User createdUser = userRepository.save(newUser);
        String location = "/api/users/" + createdUser.getUsername();

        return ResponseEntity.created(new URI(location)).build();
    }
}
