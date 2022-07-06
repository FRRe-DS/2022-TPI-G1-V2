FROM openjdk:11
VOLUME /tmp
EXPOSE 8004
ADD ./target/travel-0.0.1-SNAPSHOT.jar travel-service.jar
ENTRYPOINT ["java","-jar","/travel-service.jar"]

