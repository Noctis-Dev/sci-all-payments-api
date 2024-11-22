FROM amazoncorretto:17-alpine-jdk
ADD target/payments.jar payments.jar
ENTRYPOINT ["java", "-jar", "payments.jar"]