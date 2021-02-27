# Getting Started - BKN Oauth

### Reference Documentation
For further reference, please consider the following sections:

* [Docker Container's Architecture Diagram](https://github.com/fernandooliveira19/bookings-architecture-diagram) 

### Dependencies

Dependencies used in this project

* Oauth 
* Actuator
* Eureka Client

### Docker's commands


create network

* $ docker network create bkn-net

clean and package

* $ .\mvnw clean package -DskipTests

build docker image

* $ docker build -t bkn-oauth:v1 .

run docker container

* $ docker run -P --network bkn-net -e SERVER_CLOUD_CONFIG_URI=${SERVER_CLOUD_CONFIG_URI} bkn-oauth:v1 


