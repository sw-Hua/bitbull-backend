FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./target/business-service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "business-service-0.0.1-SNAPSHOT.jar"]