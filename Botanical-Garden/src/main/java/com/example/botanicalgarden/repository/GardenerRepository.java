package com.example.botanicalgarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.botanicalgarden.model.Gardener;

@Repository
public interface GardenerRepository extends JpaRepository<Gardener, Long> {
}