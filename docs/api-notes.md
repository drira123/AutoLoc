# Atelier 5 — API REST

## 1. Objectif

L'objectif de cet atelier est d'exposer les fonctionnalités du projet AutoLoc à travers une API REST développée avec Spring Boot.

L'atelier porte uniquement sur les deux entités suivantes :

- `Agence`
- `Vehicule`

Les controllers REST permettent aux clients externes d'effectuer des opérations sur ces ressources à l'aide de requêtes HTTP.

## 2. Architecture de l'API

L'API utilise les couches suivantes :

- **Entity** : représente les données métier.
- **Repository** : permet l'accès à la base de données.
- **Service** : contient la logique métier.
- **REST Controller** : expose les fonctionnalités à travers des endpoints HTTP.

Les controllers concernés sont :

- `AgenceRestController`
- `VehiculeRestController`

## 3. Endpoints de l'entité Agence

Le controller `AgenceRestController` expose les opérations suivantes.

| Méthode HTTP | Endpoint | Description |
|---|---|---|
| POST | `/api/agences/add` | Ajouter une agence |
| GET | `/api/agences/all` | Récupérer toutes les agences |
| GET | `/api/agences/get/{idAgence}` | Récupérer une agence par son identifiant |
| PUT | `/api/agences/update/{idAgence}` | Modifier une agence |
| DELETE | `/api/agences/delete/{idAgence}` | Supprimer une agence |

## 4. Endpoints de l'entité Vehicule

Le controller `VehiculeRestController` expose les opérations suivantes.

| Méthode HTTP | Endpoint | Description |
|---|---|---|
| POST | `/api/vehicules/add` | Ajouter un véhicule |
| GET | `/api/vehicules/all` | Récupérer tous les véhicules |
| GET | `/api/vehicules/get/{idVehicule}` | Récupérer un véhicule par son identifiant |
| PUT | `/api/vehicules/update/{idVehicule}` | Modifier un véhicule |
| DELETE | `/api/vehicules/delete/{idVehicule}` | Supprimer un véhicule |

**Remarque :** si le projet définit un `server.servlet.context-path=/api`, il faut vérifier les mappings des controllers pour éviter de répéter le préfixe `/api` dans l'URL finale. Les endpoints ci-dessus reprennent les routes déclarées dans les controllers ; les URLs réellement accessibles dépendent de la configuration Spring Boot.

## 5. Méthodes HTTP utilisées

- `GET` : lire des ressources.
- `POST` : créer une ressource.
- `PUT` : modifier une ressource.
- `DELETE` : supprimer une ressource.

Les réponses HTTP indiquent au client si la requête a été traitée correctement.

## 6. Association entre Agence et Vehicule

Une agence peut posséder plusieurs véhicules. La relation est représentée par une association `@OneToMany` dans `Agence`.

Chaque véhicule est associé à une agence à l'aide d'une association `@ManyToOne` dans `Vehicule`.

La clé étrangère `id_agence` est définie dans la table correspondant à `Vehicule`.

Cette relation permet de représenter les véhicules rattachés à une agence.

## 7. Gestion de la sérialisation JSON

L'association bidirectionnelle entre `Agence` et `Vehicule` peut provoquer une récursion lors de la conversion des objets en JSON.

Dans le projet, les annotations suivantes sont utilisées :

- `@JsonManagedReference("agence-vehicules")` dans `Agence`.
- `@JsonBackReference("agence-vehicules")` dans `Vehicule`.

Ces annotations permettent de gérer la sérialisation de cette association et d'éviter la boucle de référence entre une agence et ses véhicules.

## 8. Tests avec Postman

Postman peut être utilisé pour vérifier le fonctionnement des endpoints.

Pour chaque entité, les tests peuvent inclure :

1. Ajouter une ressource avec une requête `POST`.
2. Consulter toutes les ressources avec une requête `GET`.
3. Consulter une ressource par son identifiant.
4. Modifier une ressource avec une requête `PUT`.
5. Supprimer une ressource avec une requête `DELETE`.

Pour les requêtes `POST` et `PUT`, le corps de la requête doit contenir un JSON correspondant aux champs attendus par le controller et l'entité.

Les résultats doivent être vérifiés à partir du code de réponse HTTP et du contenu retourné.

## 9. Documentation Swagger / OpenAPI

Le projet possède une dépendance SpringDoc OpenAPI dans son fichier `pom.xml`.

Cette dépendance permet de générer une documentation interactive de l'API lorsque SpringDoc est correctement configuré et que la version utilisée est compatible avec la version de Spring Boot du projet.

L'interface Swagger UI est généralement accessible à une URL telle que :

`http://localhost:8082/swagger-ui/index.html`

L'URL exacte dépend de la configuration de l'application et du context path.

Il faut vérifier que l'application démarre correctement et que la documentation est accessible avant de confirmer le résultat.

## 10. SonarQube et qualité du code

SonarQube est un outil permettant d'analyser la qualité du code source.

Il peut détecter :

- Des problèmes de maintenabilité.
- Des duplications de code.
- Des problèmes potentiels de fiabilité.
- Des vulnérabilités ou mauvaises pratiques potentielles.

Une analyse SonarQube doit être réellement exécutée pour présenter ses résultats. Aucun résultat d'analyse n'est indiqué ici, car il doit être obtenu à partir de l'exécution sur le projet.

## 11. Gestion des erreurs HTTP

Les erreurs doivent être traitées afin de retourner des réponses adaptées au client.

Exemples de codes HTTP :

- `200 OK` : requête exécutée avec succès.
- `201 Created` : ressource créée.
- `204 No Content` : requête réussie sans contenu de réponse.
- `400 Bad Request` : requête invalide.
- `404 Not Found` : ressource introuvable.
- `500 Internal Server Error` : erreur serveur inattendue.

Les codes effectivement retournés par l'application doivent être vérifiés lors des tests.

## 12. Conclusion

Cet atelier permet de comprendre comment exposer les fonctionnalités d'AutoLoc à travers une API REST.

Les controllers `AgenceRestController` et `VehiculeRestController` permettent d'accéder aux opérations CRUD des deux entités étudiées.

L'utilisation de Spring Data JPA, des services et des annotations Jackson permet d'organiser l'accès aux données et de gérer la relation entre une agence et ses véhicules.