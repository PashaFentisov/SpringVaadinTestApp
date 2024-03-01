package com.pashonokk.springvaadintestapp.controller;

import com.pashonokk.springvaadintestapp.dto.UserSavingDto;
import com.pashonokk.springvaadintestapp.entity.User;
import com.pashonokk.springvaadintestapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserSavingDto userSavingDto) {
        return ResponseEntity.ok(userService.saveUser(userSavingDto));
    }
}
