FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/information-service-1.0.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/information-service-1.0.0-SNAPSHOT.jar"]

EXPOSE 7000