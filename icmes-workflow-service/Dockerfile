FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-workflow-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-workflow-service.jar"]

EXPOSE 7800