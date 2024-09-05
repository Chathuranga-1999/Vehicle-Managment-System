package com.Vehicle_Managment_System.login_service.repository;

import com.Vehicle_Managment_System.login_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username); // Custom query to find a user by username

    void deleteByUsername(String username);
}
