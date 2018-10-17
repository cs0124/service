FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-monitoring-center.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-monitoring-center.jar"]

EXPOSE 8989 8080