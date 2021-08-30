FROM amazoncorretto:11-alpine-jdk
MAINTAINER nobody.com
COPY target/alpha.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]