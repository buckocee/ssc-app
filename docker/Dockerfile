FROM openjdk:8-jdk-alpine
MAINTAINER buckocee@gmail.com
COPY ssc-app-1.0-SNAPSHOT.jar /home/ssc-app-1.0-SNAPSHOT.jar
CMD ["java","-Dspring.profiles.active=$PROFILE","-jar","/home/ssc-app-1.0-SNAPSHOT.jar"]