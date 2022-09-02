FROM openjdk:17-alpine
COPY target/doubler-service-1.0.jar doubler-service.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/doubler-service.jar"]