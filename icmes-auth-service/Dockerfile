FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-auth-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-auth-service.jar"]

EXPOSE 5500
