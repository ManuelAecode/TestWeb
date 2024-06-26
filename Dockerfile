FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/testweb-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} testweb.jar
ENTRYPOINT ["java","-jar","/testweb.jar"]
