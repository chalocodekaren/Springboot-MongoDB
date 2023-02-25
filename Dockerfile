FROM openjdk:17-alpine
ADD /target/SpringbootWithMongoDB-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java", "-jar", "/SpringbootWithMongoDB-0.0.1-SNAPSHOT.jar"]


