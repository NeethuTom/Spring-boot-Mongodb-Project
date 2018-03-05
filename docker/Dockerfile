FROM openjdk:8-jdk
MAINTAINER neethutom2@gmail.com

ADD springboot-mongo-demo.jar springboot-mongo-demo.jar
RUN sh -c 'touch /springboot-mongo-demo.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://spring-demo-mongo/collectionUsers","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-mongo-demo.jar"]