### ✍️ About the service
**Main Service** - is a part of the Appeals Project.  
It handles user sending appeal to the users and mayors answering on the appeals.
---
### ⚒️ Tech
- Java 21
- Spring Boot 4.0.0
- Lombok
- Postgres
- FlyWay
- Maven
- Docker
- Apache Kafka (Consumer)

---
### ⚙️ Project Structure
``` bash
├── Dockerfile
├── compose.yaml
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── main
│   │   │       ├── configuration
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       │   ├── enums
│   │   │       │   ├── feign
│   │   │       │   └── request
│   │   │       ├── entity
│   │   │       ├── event
│   │   │       ├── feign
│   │   │       ├── producer
│   │   │       ├── repository
│   │   │       ├── security
│   │   │       └── service
│   │   └── resources
│   └── test
```

---
### 🧩 Start project

``` bash
git clone https://github.com/pepegazxc/MainService-appealsProject.git
cd MainService-appealsProject
```

Then your must create .env file:
``` bash
touch .env
```

And then fill it (example data):
``` file
JWT_KEY=jwt_key
POSTGRES_PASSWORD=password
POSTGRES_USERNAME=user
POSTGRES_DB=postgres
INTERNAL_SECRET=secret
REG_URL=http://localhost:8081
REG_DOCKER_URL=http://registration-service:8081
POSTGRES_URL=jdbc:postgresql://localhost:5431/postgres
```

And then run the containers:
``` bash
docker-compose up -d
```

---
### 🔙 Back to navigate repository

Navigate repository: [AppealsProject](https://github.com/pepegazxc/Appeals-Project.git)
