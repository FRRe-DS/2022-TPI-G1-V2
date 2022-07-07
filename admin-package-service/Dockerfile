FROM openjdk:11
VOLUME /tmp
EXPOSE 8002
ADD ./target/adminservice-0.0.1-SNAPSHOT.jar package-admin-service.jar
ENTRYPOINT ["java","-jar","/package-admin-service.jar"]

