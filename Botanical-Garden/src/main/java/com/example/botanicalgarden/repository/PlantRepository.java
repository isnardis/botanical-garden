package com.example.botanicalgarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.botanicalgarden.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
}