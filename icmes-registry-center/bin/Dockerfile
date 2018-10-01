FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-registry-center-1.0.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-registry-center-1.0.0-SNAPSHOT.jar"]

EXPOSE 8761