package com.example.botanicalgarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.botanicalgarden.model.GardenSection;

@Repository
public interface GardenSectionRepository extends JpaRepository<GardenSection, Long> {
}