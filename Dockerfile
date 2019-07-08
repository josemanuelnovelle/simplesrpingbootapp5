FROM openjdk:8-jre-alpine
VOLUME /temp
COPY /target/simpleappspringboot3-0.0.1-SNAPSHOT.jar simpleappspringboot3-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/simpleappspringboot3-0.0.1-SNAPSHOT.jar"]