FROM openjdk:11.0.12-jdk-slim-buster

RUN apt-get update && apt-get upgrade -y

ADD target/master-controller-2.0.0.jar master_controller.jar
