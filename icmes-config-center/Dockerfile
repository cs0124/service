FROM java:8-jre
MAINTAINER dtelec developer

ADD ./target/icmes-config-center.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/icmes-config-center.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8888/actuator/health || exit 1

EXPOSE 8888