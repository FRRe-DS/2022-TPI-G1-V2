FROM openjdk:11
VOLUME /tmp
EXPOSE 8007
ADD ./target/payment_service-0.0.1-SNAPSHOT.jar payment-service.jar
ENTRYPOINT ["java","-jar","/payment-service.jar"]

