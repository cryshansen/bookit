package com.artog.bookit.controller;

import com.artog.bookit.repository.HealthCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import com.artog.bookit.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

     @Autowired
    private HealthCheckRepository healthCheckRepository;

    @GetMapping("/db")
    public ResponseEntity<String> checkDbConnection() {
        try {
            String message = healthCheckRepository.checkDatabaseConnection();
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Database connection failed: " + e.getMessage());
        }
    }
}

