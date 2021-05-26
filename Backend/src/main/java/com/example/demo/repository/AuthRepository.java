package com.example.demo.repository;

import com.example.demo.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Auth findByMail(String mail);
}
