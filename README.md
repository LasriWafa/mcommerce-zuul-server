# MCommerce Zuul Server (TP5)

This project implements the **API Gateway** for the MCommerce microservices project using **Spring Cloud Zuul**.  
It is part of TP5 for the JEE module.

---

## 🎯 Purpose of TP5

The main goal of this TP is to:

1. Implement an **API Gateway** using **Zuul**.
2. Enable **service discovery** via **Eureka**.
3. Demonstrate **load balancing** between multiple instances of a microservice.
4. Apply **pre- and post-filters** to log requests and responses.
5. Integrate **Spring Cloud Config Server** to centralize microservice configurations.

---

## ⚙️ Prerequisites

Before running this project, you need:

1. **TP3 — Spring Cloud Config Server**
    - Provides centralized configuration files for microservices.
2. **TP4 — Eureka Server & Product Microservice**
    - Eureka Server for service discovery.
    - At least **two instances** of the Product microservice to demonstrate routing and load balancing.
3. **Java 1.8** or higher
4. **Maven**
5. **Postman** (or any HTTP client) to test API endpoints.

---

## 📁 Project Structure

```

zuul-server
│
├── src/main/java/com/mcommerce/zuulserver
│ ├── ZuulServerApplication.java
│ └── filters
│ ├── MyZuulLogFilter.java
│ └── MyZuulReponseFilter.java
│
├── src/main/resources
│ ├── bootstrap.properties
│ └── application.properties (empty)
│
└── pom.xml

```


---

## 🛠 Configuration Files

### bootstrap.properties (local)
```properties
spring.application.name=zuul-server
spring.cloud.config.uri=http://localhost:9101

```
### zuul-server.properties (GitHub config repo)

```properties
server.port=9004
eureka.client.serviceUrl.defaultZone=http://localhost:9102/eureka/

```

The zuul-server.properties file is pushed to the Config Server GitHub repository so that the Zuul server can fetch its configuration dynamically.

## How to Run (after TP3 + TP4 are ready)

1. Start the Config Server (TP3)

2. Start the Eureka Server (TP4)

3. Start two instances of Product microservice (TP4) on different ports

4. Run the Zuul Server on port 9004

Access Product microservice via Zuul:

```
http://localhost:9004/microservice-produits/Produits
```

- Each request will be routed to one of the Product microservice instances (round-robin load balancing).

- Pre- and post-filters log requests and responses to the console.
