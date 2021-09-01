FROM amazoncorretto:11-alpine-jdk

RUN apk --no-cache add curl

MAINTAINER nobody.com
COPY target/gamma.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]