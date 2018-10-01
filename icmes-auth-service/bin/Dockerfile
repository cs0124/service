FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-auth-service-1.0.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-auth-service-1.0.0-SNAPSHOT.jar"]

EXPOSE 5000
