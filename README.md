# Hackathon 22
## Spring Boot Application

#### Pre-requisites

- Maven
- Start docker
- Update the following properties:
    - `MYSQL_ROOT_PASSWORD` in `docker-compose.yaml`
    - `spring.datasource.password` in `spring-boot-application/src/main/resources/application.yaml`

#### Build
```sh
./build
```

#### Start
```sh
docker-compose up -d
```

> Note: **-d** will start in detached mode

#### Stop
```sh
docker-compose stop
```

#### Clean
```sh
./cleanup
```

## Tech-Stack

- [Spring Boot] - Monitoring Application
- [MySQL] - RDBMS
- [RabbitMQ] - message broker
- [Docker] - build
- [docker-compose] - build, run, etc

> Note: 1. Use **linux-based** terminal for all commands and run from root directory

> Note: 2. Stop existing running instance for MySQL, RabbitMQ (if any)

> Note: 3. Make sure to run **cleanup** script before redeploying

**Code Black**

