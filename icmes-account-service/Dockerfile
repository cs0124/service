FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-account-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-account-service.jar"]

EXPOSE 6000