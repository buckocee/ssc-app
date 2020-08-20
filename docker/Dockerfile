FROM openjdk:8-jdk-alpine
MAINTAINER "bukhosi@silvershield.com"
COPY ../target/ssc-0.0.1-SNAPSHOT.jar ssc-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ssc-0.0.1-SNAPSHOT.jar"]
HEALTHCHECK --interval=5m --timeout=2s --retries=3 CMD curl -f http://localhost:8080/health || exit 1
EXPOSE 8080
