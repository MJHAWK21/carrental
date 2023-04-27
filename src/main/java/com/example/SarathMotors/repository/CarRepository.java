package com.example.SarathMotors.repository;

import com.example.SarathMotors.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Cars,Long> {
    List<Cars> findByDate(String date);
}
