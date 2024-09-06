package com.Vehicle_Managment_System.login_service.service;


import com.Vehicle_Managment_System.login_service.model.User;
import com.Vehicle_Managment_System.login_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    // Register a new user with encrypted password
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password before saving
        user.setRole("USER"); // Default role
        return userRepository.save(user);
    }

    // Authenticate user with password check
    public boolean authenticateUser(User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        return foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword());
    }

    // Delete user by username
    public boolean deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.deleteByUsername(username);
            return true;
        }
        return false;
    }

    // Reset password for user
    public boolean resetPassword(String username, String newPassword) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword)); // Encrypt new password before saving
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
