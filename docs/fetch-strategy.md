# Atelier 2 — Fetch Strategies

## 1. Objectif

L'objectif de cet atelier est de comprendre les stratégies de chargement des associations entre les entités JPA dans le projet AutoLoc.

Les deux stratégies principales sont :

- **LAZY** : les données associées sont chargées uniquement lorsqu'elles sont utilisées.
- **EAGER** : les données associées sont chargées immédiatement avec l'entité principale, selon le fonctionnement du fournisseur JPA.

## 2. Entité Agence

L'entité `Agence` contient les informations suivantes :

- `idAgence`
- `ville`
- `adresse`
- `telephone`

Elle possède également une association `@OneToMany` avec l'entité `Vehicule`.

Cette association utilise `mappedBy = "agence"` et `FetchType.LAZY`.

Cela signifie que les véhicules d'une agence ne sont pas nécessairement chargés lorsque l'agence est récupérée. Ils sont chargés lorsque la collection est utilisée, si le contexte de persistance le permet.

## 3. Entité Vehicule

L'entité `Vehicule` contient notamment :

- `idVehicule`
- `immatriculation`
- `marque`
- `modele`
- `categorie`
- `tarifJournalier`
- `statut`

Elle possède une association `@ManyToOne` avec `Agence`, configurée avec `FetchType.LAZY`.

Le véhicule est donc l'entité propriétaire de cette association, avec la clé étrangère `id_agence`.

## 4. Comparaison des stratégies

| Stratégie | Description | Avantage | Inconvénient |
|---|---|---|---|
| LAZY | Chargement à la demande | Évite de charger inutilement les associations | Peut provoquer une erreur si la relation est utilisée hors du contexte de persistance |
| EAGER | Chargement immédiat des associations concernées | Les données associées sont disponibles plus tôt | Peut charger des données inutiles et augmenter le coût des requêtes |

## 5. Choix dans AutoLoc

Le projet utilise `FetchType.LAZY` pour l'association entre `Agence` et `Vehicule`, dans les deux sens.

Ce choix permet de limiter le chargement automatique des données associées et de mieux contrôler les données récupérées.

## 6. Conclusion

Les stratégies de chargement ont un impact sur les performances et sur la manière dont les relations entre les entités sont utilisées.

Dans AutoLoc, le chargement différé est utilisé pour l'association entre `Agence` et `Vehicule` afin d'éviter de charger systématiquement toutes les données liées.