FROM openjdk:8u171-jdk-alpine3.8
VOLUME /home/config
ADD config-server-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]