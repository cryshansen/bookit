package com.artog.bookit.repository;
import com.artog.bookit.model.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface HealthCheckRepository extends JpaRepository<Appointment, Long> {
    @Query(value = "SELECT 'The DB is connected' AS message", nativeQuery = true)
    String checkDatabaseConnection();
}
