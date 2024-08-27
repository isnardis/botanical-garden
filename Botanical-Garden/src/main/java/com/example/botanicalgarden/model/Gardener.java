package com.example.botanicalgarden.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

// Voici notre classe Gardener, c'est comme la carte d'identité de nos jardiniers !

@Entity
public class Gardener {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; 
    private String specialization;

    @OneToMany(mappedBy = "responsibleGardener")
    private Set<GardenSection> responsibleSections = new HashSet<>();

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Set<GardenSection> getResponsibleSections() {
        return responsibleSections;
    }

    public void setResponsibleSections(Set<GardenSection> responsibleSections) {
        this.responsibleSections = responsibleSections;
    }
}