FROM openjdk:17-alpine
EXPOSE 8080:8081
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY demo-0.0.1-SNAPSHOT.jar demo-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/demo-SNAPSHOT.jar"]

