FROM openjdk:11
VOLUME /tmp
EXPOSE 8003
ADD ./target/ServiceHealthInsurance-0.0.1-SNAPSHOT.jar service-health-insurance.jar
ENTRYPOINT ["java","-jar","/service-health-insurance.jar"]

