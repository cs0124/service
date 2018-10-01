FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-registry-center.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-registry-center.jar"]

EXPOSE 8761