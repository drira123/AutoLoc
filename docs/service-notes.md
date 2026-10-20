# Atelier 4 — Service Layer

## 1. Objectif

L'objectif de cet atelier est de comprendre le rôle de la couche Service dans une application Spring Boot.

La couche Service se situe entre les controllers et les repositories. Elle contient la logique métier et coordonne les opérations sur les données.

## 2. Services du projet AutoLoc

Le projet comporte une couche de service pour les entités `Agence` et `Vehicule`.

Cette couche utilise les repositories correspondants pour effectuer les opérations de lecture, d'ajout, de modification et de suppression.

## 3. Service Agence

Le service de l'entité `Agence` prend en charge les opérations métier relatives aux agences.

L'implémentation `AgenceServiceImpl` utilise `IAgenceRepository`.

Elle vérifie notamment certaines données de l'agence, comme la ville et l'adresse, et peut déclencher une exception lorsque les données ne sont pas valides ou lorsqu'une agence recherchée n'existe pas.

## 4. Service Vehicule

Le service de l'entité `Vehicule` prend en charge les opérations métier relatives aux véhicules.

Il utilise `IVehiculeRepository` pour accéder aux données et effectuer les opérations nécessaires.

Il sert d'intermédiaire entre le controller REST et la couche Repository.

## 5. Pourquoi séparer Controller, Service et Repository ?

Cette séparation permet de :

- Ne pas placer toute la logique métier dans les controllers.
- Réutiliser la logique métier.
- Faciliter les tests.
- Simplifier la maintenance.
- Limiter le couplage entre les différentes couches.

## 6. Gestion des erreurs

Les services peuvent signaler des erreurs lorsque les données reçues ne sont pas valides ou lorsqu'une ressource n'existe pas.

Pour une API REST, ces erreurs doivent être traduites en réponses HTTP appropriées, par exemple :

- `400 Bad Request` pour des données invalides.
- `404 Not Found` lorsqu'une ressource est introuvable.
- `500 Internal Server Error` pour une erreur serveur inattendue.

La présence de ces réponses dépend de la manière dont les exceptions sont gérées dans l'application.

## 7. Conclusion

La couche Service centralise la logique métier et sépare les traitements métier de l'accès aux données et de la gestion des requêtes HTTP.

Dans AutoLoc, les services d'`Agence` et de `Vehicule` assurent cette séparation entre les controllers REST et les repositories.