package com.example.botanicalgarden.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String species;
    private String description;

    @Enumerated(EnumType.STRING)
    private PlantType type;

    @ElementCollection
    private Set<String> categories = new HashSet<>();

    @ElementCollection
    private List<String> careInstructions = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "plant_attributes")
    @MapKeyColumn(name = "attribute_key")
    @Column(name = "attribute_value")
    private Map<String, String> attributes = new HashMap<>();

    @ManyToOne
    @JoinColumn(name = "garden_section_id")
    private GardenSection gardenSection;

    // Enum PlantType
    public enum PlantType {
        TREE, SHRUB, FLOWER, GRASS, VINE, AQUATIC
    }

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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public List<String> getCareInstructions() {
        return careInstructions;
    }

    public void setCareInstructions(List<String> careInstructions) {
        this.careInstructions = careInstructions;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public GardenSection getGardenSection() {
        return gardenSection;
    }

    public void setGardenSection(GardenSection gardenSection) {
        this.gardenSection = gardenSection;
    }

}