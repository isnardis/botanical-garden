# botanical-garden
Rendu du projet de JAVA de Ana ISNARDIS, Khalil EL HOUFI et Maxime ANTIGNAC.
Août 2024.

# Ce projet est une API REST pour la gestion d'un jardin botanique, développée avec Spring Boot.
Configuration et Lancement
1. Clonez ce repository
2. Assurez-vous d'avoir Java 11+ et Maven installés
3. Dans le dossier du projet, exécutez:
```
mvn spring-boot:run
```

L'application sera accessible à
`http://localhost:8080`

# Endpoints API
## Plants

* GET /api/plants : Liste toutes les plantes
* POST /api/plants : Crée une nouvelle plante
* GET /api/plants/{id} : Récupère une plante spécifique
* PUT /api/plants/{id} : Met à jour une plante
* DELETE /api/plants/{id} : Supprime une plante

## Garden Sections
* GET /api/sections : Liste toutes les sections
* POST /api/sections : Crée une nouvelle section
* GET /api/sections/{id} : Récupère une section spécifique
* PUT /api/sections/{id} : Met à jour une section
* DELETE /api/sections/{id} : Supprime une section Gardeners
* GET /api/gardeners : Liste tous les jardiniers
* POST /api/gardeners : Crée un nouveau jardinier
* GET /api/gardeners/{id} : Récupère un jardinier spécifique
* PUT /api/gardeners/{id} : Met à jour un jardinier
* DELETE /api/gardeners/{id} : Supprime un jardinier
Exemple d'utilisation
Création d'une plante : 
```
POST /api/plants
{
"name": "Rose Rouge",
"species": "Rosa gallica", "description": "Une belle rose rouge", "type": "FLOWER"
}
```

# Structure du Projet
* `src/main/java/com/example/botanicalgarden/` : Code source Java
* `model/` : Entités JPA
* `repository/` : Interfaces Repository
* `controller/` : Contrôleurs REST
* `src/main/resources/` : Fichiers de configuration - `pom.xml` : Configuration Maven et dépendances
Choix de Conception
* Utilisation de Spring Data JPA pour la persistance
* API RESTful avec opérations CRUD pour chaque entité
