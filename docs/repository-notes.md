# Atelier 3 — Repository Layer

## 1. Objectif

L'objectif de cet atelier est de comprendre le rôle de la couche Repository dans une application Spring Boot utilisant Spring Data JPA.

La couche Repository permet d'accéder aux données de la base de données sans écrire manuellement les requêtes SQL pour les opérations CRUD courantes.

## 2. Repository de l'entité Agence

Le projet contient l'interface `IAgenceRepository`, qui étend `JpaRepository`.

Cette interface permet notamment de :

- Ajouter une agence.
- Récupérer toutes les agences.
- Rechercher une agence par son identifiant.
- Modifier une agence.
- Supprimer une agence.

Spring Data JPA fournit automatiquement les méthodes CRUD héritées de `JpaRepository`.

## 3. Repository de l'entité Vehicule

Le projet contient également l'interface `IVehiculeRepository`, qui étend `JpaRepository`.

Elle permet d'effectuer les opérations CRUD sur les véhicules.

Les services utilisent cette interface pour accéder aux données des véhicules.

## 4. Pourquoi utiliser JpaRepository ?

L'utilisation de `JpaRepository` présente plusieurs avantages :

- Réduction du code répétitif.
- Simplification des opérations CRUD.
- Intégration avec Spring Data JPA.
- Possibilité d'ajouter des méthodes de recherche personnalisées.
- Séparation entre l'accès aux données et la logique métier.

## 5. Séparation des responsabilités

L'architecture du projet respecte la séparation suivante :

- **Entity** : représente les objets persistés en base de données.
- **Repository** : assure l'accès aux données.
- **Service** : contient la logique métier et utilise les repositories.
- **Controller** : reçoit les requêtes HTTP et appelle les services.

Cette organisation rend le code plus lisible, maintenable et évolutif.

## 6. Conclusion

Les repositories simplifient la communication avec la base de données et évitent de mélanger les opérations de persistance avec la logique métier.

Dans AutoLoc, `IAgenceRepository` et `IVehiculeRepository` assurent l'accès aux données des deux entités principales étudiées dans cet atelier.