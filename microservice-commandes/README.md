# 🧾 Microservice Commandes

## 📌 Description
Le microservice **Commandes** est une application Spring Boot faisant partie d’une architecture **microservices**.  
Il permet la gestion des commandes via une API REST (CRUD) et utilise une base de données **H2**.  
La configuration est centralisée grâce à **Spring Cloud Config Server** et peut être mise à jour dynamiquement sans redémarrage.

---

## 🛠️ Technologies utilisées
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web (REST API)
- H2 Database (in-memory)
- Spring Cloud Config Client
- Spring Boot Actuator
- Maven
- Postman (tests)

---

## 🧱 Structure du projet
microservice-commandes
│
├── controller
├── service
├── repository
├── domain
│ └── Commande.java
├── resources
│ └── application.properties
└── MicroserviceCommandesApplication.java


---

## 📊 Entité Commande
```text
id
description
quantite
date
montant
idProduit
🚀 Démarrage de l’application
Prérequis
Java 17

Maven

Config Server en cours d’exécution (port 8888)

Lancer le microservice

mvn spring-boot:run
L’application démarre sur le port 8082.

🔗 Configuration centralisée
La configuration est chargée depuis un Spring Cloud Config Server connecté à GitHub.

Propriété métier
properties

mes-config-ms.commandes-last
Elle permet de définir le nombre de jours à prendre en compte pour récupérer les dernières commandes.

🔁 Rafraîchissement de la configuration (Hot Reload)
Après modification dans GitHub :

http
POST http://localhost:8082/actuator/refresh
➡️ La nouvelle configuration est appliquée sans redémarrage du microservice.

🔎 Endpoints REST
➕ Ajouter une commande
http

POST /api/commandes
json

{
  "description": "Commande produit",
  "quantite": 1,
  "date": "2025-12-25",
  "montant": 5000,
  "idProduit": 1
}
📥 Lister les commandes
http

GET /api/commandes
📄 Récupérer une commande par ID
http

GET /api/commandes/{id}
✏️ Modifier une commande
http

PUT /api/commandes/{id}
🗑 Supprimer une commande
http

DELETE /api/commandes/{id}
📆 Commandes des derniers jours
http

GET /api/commandes/last
Retourne les commandes des X derniers jours, selon la valeur de mes-config-ms.commandes-last.

❤️ Supervision
État du microservice
http

GET /actuator/health
Résultat attendu :

json

{
  "status": "UP"
}
🗄️ Console H2
URL : http://localhost:8082/h2-console

JDBC URL : jdbc:h2:mem:commandes-db

User : sa

Password : (vide)

✅ État du projet
Étude de cas 1 : ✅ Terminée

Étude de cas 2 : 🚧 En cours

👤 Auteur
Adam Tefor
Othman chahbouni daoudi
Étudiant en ingénierie informatique
Projet académique – Architecture Microservices (JEE)


