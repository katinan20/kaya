FROM openjdk:17-oracle

VOLUME /tmp
COPY .env /app/.env
COPY target/kaya01-0.0.1-SNAPSHOT.jar /app/kaya.jar
WORKDIR /app

ENTRYPOINT ["java", "-jar", "kaya.jar"]
