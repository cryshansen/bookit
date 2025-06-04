FROM openjdk:17
RUN apt-get update && apt-get install -y iputils-ping netcat
WORKDIR /app
COPY target/bookit-0.0.1-SNAPSHOT.jar bookit.jar
EXPOSE 8181
CMD ["java", "-jar", "bookit.jar"]




