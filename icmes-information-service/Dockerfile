FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-information-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-information-service.jar"]

EXPOSE 7000