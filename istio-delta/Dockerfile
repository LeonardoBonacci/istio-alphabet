FROM amazoncorretto:11-alpine-jdk

RUN apk --no-cache add curl

MAINTAINER nobody.com
COPY target/alpha.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]