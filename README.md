# JEE Microservices - Devoir Module Microservices

Ce dépôt contient l’ensemble du devoir sous forme de **mono-repo** :
- Config Server (Spring Cloud Config)
- Eureka Server (Service Discovery)
- API Gateway (Spring Cloud Gateway)
- Microservice Commandes
- Microservice Produits

## Architecture

jee-microservices/
├─ config-server/
├─ eureka-server/
├─ api-gateway/
├─ microservice-commandes/
├─ microservice-produits/
└─ README.md

markdown
Copier le code

## Prérequis

- Java 17
- Maven 3.x
- Git
- Postman (optionnel pour tester)
- IntelliJ IDEA (recommandé)

## Ports utilisés

| Service | Port |
|--------|------|
| Config Server | 8888 |
| Eureka Server | 8761 |
| API Gateway | 8085 |
| Microservice Commandes | 8082 |
| Microservice Produits | 8083 |

## Démarrage (ordre obligatoire)

1) **Config Server**
```bash
cd config-server
mvn spring-boot:run
Eureka Server

bash
Copier le code
cd ../eureka-server
mvn spring-boot:run
Microservice Produits

bash
Copier le code
cd ../microservice-produits
mvn spring-boot:run
Microservice Commandes

bash
Copier le code
cd ../microservice-commandes
mvn spring-boot:run
API Gateway

bash
Copier le code
cd ../api-gateway
mvn spring-boot:run
Vérifications rapides
Eureka UI
http://localhost:8761
Tu dois voir :

MICROSERVICE-COMMANDES (UP)

MICROSERVICE-PRODUITS (UP)

API-GATEWAY (UP)

Config Server
http://localhost:8888/microservice-commandes/default

http://localhost:8888/microservice-produits/default

Tests Postman (exemples)
Produits (direct)
POST http://localhost:8083/api/produits

json
Copier le code
{
  "nom": "Clavier",
  "prix": 300,
  "quantiteStock": 50
}
GET http://localhost:8083/api/produits

Commandes (direct)
POST http://localhost:8082/api/commandes

json
Copier le code
{
  "description": "Commande clavier",
  "quantite": 2,
  "date": "2025-12-26",
  "montant": 600,
  "idProduit": 1
}
GET http://localhost:8082/api/commandes

GET http://localhost:8082/api/commandes/1/details
(Doit retourner la commande + les infos produit via Feign)

Via Gateway (recommandé)
Produits :

http://localhost:8085/api/produits

Commandes :

http://localhost:8085/api/commandes

http://localhost:8085/api/commandes/1/details

Fallback Feign (résilience)
Si microservice-produits est arrêté, microservice-commandes doit continuer à répondre
sur /api/commandes/{id}/details en renvoyant un produit fallback (ex: "Produit indisponible").

Auteur
Adam Tefor
Othman chahbouni-daoudi