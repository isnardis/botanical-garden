package com.example.botanicalgarden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.botanicalgarden.model.*;
import com.example.botanicalgarden.repository.*;
import java.util.List;

// Voici notre contrôleur principal pour l'API du jardin botanique.
// Il gère toutes les opérations CRUD pour les plantes, les sections de jardin et les jardiniers.

@RestController
@RequestMapping("/api")
public class BotanicalGardenController {
    // On injecte nos repositories ici. C'est comme avoir des assistants dédiés pour chaque tâche.
    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private GardenSectionRepository gardenSectionRepository;

    @Autowired
    private GardenerRepository gardenerRepository;

    // Commençons par les plantes. C'est la base de notre jardin, après tout !
    // Cette méthode nous donne toutes les plantes. Pratique pour avoir une vue d'ensemble.

    // Plant endpoints
    @GetMapping("/plants")
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    // Ici, on cherche une plante spécifique. Si on ne la trouve pas, on renvoie un 404.

    @GetMapping("/plants/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Long id) {
        return plantRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Ajoutons une nouvelle plante à notre collection. L'équivalent de planter une graine.

    @PostMapping("/plants")
    public Plant createPlant(@RequestBody Plant plant) {
        return plantRepository.save(plant);
    }
    // On peut aussi mettre à jour les infos d'une plante.

    @PutMapping("/plants/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @RequestBody Plant plantDetails) {
        return plantRepository.findById(id)
            .map(plant -> {
                plant.setName(plantDetails.getName());
                plant.setSpecies(plantDetails.getSpecies());
                plant.setDescription(plantDetails.getDescription());
                plant.setType(plantDetails.getType());
                return ResponseEntity.ok(plantRepository.save(plant));
            })
            .orElse(ResponseEntity.notFound().build());
    }
    // Et si une plante ne nous plaît plus, on peut toujours l'enlever.

    @DeleteMapping("/plants/{id}")
    public ResponseEntity<?> deletePlant(@PathVariable Long id) {
        return plantRepository.findById(id)
            .map(plant -> {
                plantRepository.delete(plant);
                return ResponseEntity.ok().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // Maintenant, passons aux sections du jardin. C'est là qu'on organise nos plantes.
    // Les mêmes opérations CRUD pour les sections...

    // GardenSection endpoints
    @GetMapping("/sections")
    public List<GardenSection> getAllSections() {
        return gardenSectionRepository.findAll();
    }

    @GetMapping("/sections/{id}")
    public ResponseEntity<GardenSection> getSectionById(@PathVariable Long id) {
        return gardenSectionRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/sections")
    public GardenSection createSection(@RequestBody GardenSection section) {
        return gardenSectionRepository.save(section);
    }

    @PutMapping("/sections/{id}")
    public ResponseEntity<GardenSection> updateSection(@PathVariable Long id, @RequestBody GardenSection sectionDetails) {
        return gardenSectionRepository.findById(id)
            .map(section -> {
                section.setName(sectionDetails.getName());
                section.setDescription(sectionDetails.getDescription());
                return ResponseEntity.ok(gardenSectionRepository.save(section));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/sections/{id}")
    public ResponseEntity<?> deleteSection(@PathVariable Long id) {
        return gardenSectionRepository.findById(id)
            .map(section -> {
                gardenSectionRepository.delete(section);
                return ResponseEntity.ok().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
    // Et enfin, les jardiniers ! Ce sont eux qui prennent soin de note précieux jardin.
    // Encore une fois, les mêmes opérations CRUD...

    // Gardener endpoints
    @GetMapping("/gardeners")
    public List<Gardener> getAllGardeners() {
        return gardenerRepository.findAll();
    }

    @GetMapping("/gardeners/{id}")
    public ResponseEntity<Gardener> getGardenerById(@PathVariable Long id) {
        return gardenerRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/gardeners")
    public Gardener createGardener(@RequestBody Gardener gardener) {
        return gardenerRepository.save(gardener);
    }

    @PutMapping("/gardeners/{id}")
    public ResponseEntity<Gardener> updateGardener(@PathVariable Long id, @RequestBody Gardener gardenerDetails) {
        return gardenerRepository.findById(id)
            .map(gardener -> {
                gardener.setName(gardenerDetails.getName());
                gardener.setSpecialization(gardenerDetails.getSpecialization());
                return ResponseEntity.ok(gardenerRepository.save(gardener));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/gardeners/{id}")
    public ResponseEntity<?> deleteGardener(@PathVariable Long id) {
        return gardenerRepository.findById(id)
            .map(gardener -> {
                gardenerRepository.delete(gardener);
                return ResponseEntity.ok().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }

}