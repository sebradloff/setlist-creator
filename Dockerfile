FROM openjdk:8-alpine

EXPOSE 8080

COPY build/libs/setlist-creator-0.0.1-SNAPSHOT.jar /app/build/libs/setlist-creator-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/build/libs/setlist-creator-0.0.1-SNAPSHOT.jar"]
