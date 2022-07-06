FROM openjdk:11
VOLUME /tmp
EXPOSE 8090
ADD ./target/zull-server-0.0.1-SNAPSHOT.jar zull-server.jar
ENTRYPOINT ["java","-jar","/zull-server.jar"]

