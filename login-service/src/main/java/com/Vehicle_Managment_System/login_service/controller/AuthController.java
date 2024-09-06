package com.Vehicle_Managment_System.login_service.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model; // This is the correct import

import com.Vehicle_Managment_System.login_service.model.User;
import com.Vehicle_Managment_System.login_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    // User Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        boolean isAuthenticated = userService.authenticateUser(user);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // User Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    // Delete User Endpoint
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        boolean isDeleted = userService.deleteUser(username);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    // Forget Password Endpoint
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String username, @RequestParam String newPassword) {
        boolean isUpdated = userService.resetPassword(username, newPassword);
        if (isUpdated) {
            return ResponseEntity.ok("Password reset successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
