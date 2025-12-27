# ⚙️ Config Server – Spring Cloud Config

## 📌 Description
Le **Config Server** est un microservice basé sur **Spring Cloud Config Server**.  
Il permet de centraliser la configuration de tous les microservices dans une architecture **microservices**, en utilisant un dépôt **GitHub** comme source de configuration.

Grâce à ce serveur, les microservices peuvent charger et rafraîchir leur configuration **sans redémarrage**.

---

## 🛠️ Technologies utilisées
- Java 17
- Spring Boot
- Spring Cloud Config Server
- Spring Boot Actuator
- Git / GitHub
- Maven

---

## 🧱 Rôle du Config Server
- Centraliser les fichiers de configuration
- Fournir la configuration aux microservices clients
- Permettre la modification dynamique des paramètres
- Éviter la duplication des fichiers `application.properties`

---

## 🚀 Démarrage de l’application

### Prérequis
- Java 17
- Maven
- Accès à Internet (GitHub)

### Lancer le Config Server
```bash
mvn spring-boot:run


Le serveur démarre sur le port 8888.

🔗 Dépôt GitHub de configuration

Le Config Server est connecté à un dépôt GitHub contenant les fichiers de configuration.

Exemple de dépôt
JEE-config-repo
│
└── microservice-commandes.properties

Exemple de configuration
mes-config-ms.commandes-last=10

🌐 Endpoints disponibles
📄 Récupérer la configuration d’un microservice
GET http://localhost:8888/microservice-commandes/default


Réponse :

{
  "name": "microservice-commandes",
  "propertySources": [
    {
      "name": "https://github.com/.../microservice-commandes.properties",
      "source": {
        "mes-config-ms.commandes-last": "10"
      }
    }
  ]
}

🔁 Mise à jour dynamique (Hot Reload)

Modifier la configuration dans GitHub

Faire un commit

Appeler l’endpoint suivant depuis le microservice client :

POST http://localhost:8082/actuator/refresh


➡️ La nouvelle configuration est appliquée sans redémarrage du microservice.

❤️ Supervision
État du Config Server
GET http://localhost:8888/actuator/health


Résultat attendu :

{
  "status": "UP"
}

🧠 Avantages du Config Server

Centralisation de la configuration

Modification rapide des paramètres

Meilleure maintenance

Adapté aux architectures microservices

📦 Microservices connectés

microservice-commandes ✅

(à venir) microservice-produits

(à venir) gateway

(à venir) eureka-server

✅ État du projet

Config Server : ✅ Fonctionnel

Connexion GitHub : ✅ OK

Rafraîchissement dynamique : ✅ OK

👤 Auteur

othman chahbouni 
Adam Tefor
