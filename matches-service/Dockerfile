FROM openjdk:11
VOLUME /tmp
EXPOSE 8001
ADD ./target/matches-0.0.1-SNAPSHOT.jar match-service.jar
ENTRYPOINT ["java","-jar","/match-service.jar"]

