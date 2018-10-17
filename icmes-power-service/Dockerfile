FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-power-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-power-service.jar"]

EXPOSE 7500