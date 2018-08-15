# Spring-Cloud-Stream-with-Kafka

An exercise to experiement Spring Cloud Stream with Kafka

# How to run

Build the Spring boot app first by
```
mvn clean install -DskipTests=true
```

Build the docker image and spin up all containers
```
docker-compose up --build
```

To trigger sending messages to Kafka
```
curl http://localhost:8080/greetings?message=hello
```

# Current issue
GreetingsListener isn't working at the moment