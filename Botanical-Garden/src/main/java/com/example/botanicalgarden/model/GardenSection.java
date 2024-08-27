package com.example.botanicalgarden.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class GardenSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "gardenSection", cascade = CascadeType.ALL)
    private Set<Plant> plants = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "gardener_id")
    private Gardener responsibleGardener;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Plant> getPlants() {
        return plants;
    }

    public void setPlants(Set<Plant> plants) {
        this.plants = plants;
    }

    public Gardener getResponsibleGardener() {
        return responsibleGardener;
    }

    public void setResponsibleGardener(Gardener responsibleGardener) {
        this.responsibleGardener = responsibleGardener;
    }

    
}