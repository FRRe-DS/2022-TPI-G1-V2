FROM openjdk:11
VOLUME /tmp
EXPOSE 8005
ADD ./target/lodging-0.0.1-SNAPSHOT.jar lodging-service.jar
ENTRYPOINT ["java","-jar","/lodging-service.jar"]

