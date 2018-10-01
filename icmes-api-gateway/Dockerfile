FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-api-gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-api-gateway.jar"]

EXPOSE 4000