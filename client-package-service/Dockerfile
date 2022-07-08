FROM openjdk:11
VOLUME /tmp
EXPOSE 8009
ADD ./target/client-package-service-0.0.1-SNAPSHOT.jar package-client-service.jar
ENTRYPOINT ["java","-jar","/package-client-service.jar"]

