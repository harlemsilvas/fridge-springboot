1) Crie CONTRIBUTING.md:
```md
# Contributing Guide

Thanks for your interest in contributing! 🚀  
This project is a learning/portfolio application built with **Spring Boot + H2 + Frontend JS**.

## ✅ How to contribute

### 1) Fork the repository
Create your fork, then clone locally:

```bash
git clone https://github.com/your-username/fridge-springboot.git
cd fridge-springboot

```
---
2) Create a new branch

Use a descriptive branch name:
```bash
git checkout -b feature/my-feature
```
---
3) Run the project

You can run locally using Maven:
```bash
./mvnw spring-boot:run
```
Then open:
- UI: http://localhost:8080/index.html
- API: http://localhost:8080/foods
- H2 Console: http://localhost:8080/h2-console
---
4) Make changes
- Recommended improvements:
- Better error messages and HTTP responses
- Search by name
- Improve UI/UX
- Add categories
- Add database persistence (PostgreSQL)
---
5) Commit your changes
Keep commits clear and small:
```bash
git add .
git commit -m "feat: add search by name"
```
---
6) Push and create a Pull Request
```bash
git push origin feature/my-feature
``` 
Open a PR on GitHub and describe:
- What changed
- Why it changed
- How to test it
---
✅ Code style
- Keep packages organized:
  - controller
  - service
  - repository
  - model
  - exception
- Prefer clean REST patterns (/foods, /foods/{id})
- Use validation annotations when appropriate:
  - @NotBlank
  - @NotNull
  - @Min
✅ Reporting Bugs
Please open an issue and include:
- Steps to reproduce
- Expected behavior
- Actual behavior
- Console logs if available
Thanks! 🙌
---

# ✅ 7) `docker-compose.yml` (rodar com 1 comando)
Esse docker-compose vai:
- buildar seu projeto usando Docker
- subir um container
- expor na porta 8080

Crie **`docker-compose.yml`** na raiz:

```yaml
version: "3.9"

services:
  fridge-app:
    build: .
    container_name: fridge-app
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=default
    restart: unless-stopped
```
✅ Para isso funcionar, falta o arquivo Dockerfile também.
---
✅ 8) Dockerfile (obrigatório para o compose)
Crie um Dockerfile na raiz:
````dockerfile
# ---- Build stage ----
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# ---- Run stage ----
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```