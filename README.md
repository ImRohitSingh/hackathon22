# Hackathon 22
## Spring Boot Application

#### Pre-requisites

- Maven
- Docker
- Update the following properties:
    - `MYSQL_ROOT_PASSWORD` in `docker-compose.yaml`
    - `spring.datasource.password` in `spring-boot-application/src/main/resources/application.yaml`
- Run the following command (only once) from root directory:
```sh
docker volume create --name=grafana-volume
```

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

- [SpringBoot] - Monitoring Application
- [MySQL] - RDBMS
- [RabbitMQ] - message broker
- [GraphiteDB] - time series database
- [Grafana] - monitoring visualization tool
- [Docker] - build
- [docker-compose] - build, run, etc

> Note: 1. Use **linux-based** terminal for all commands and run from root directory

> Note: 2. Stop existing running instance for MySQL, RabbitMQ (if any)

> Note: 3. Make sure to run **cleanup** script before redeploying

**Code Black**

