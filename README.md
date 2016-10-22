# AMT Labo 1 : Discovering Java EE 

## Introduction

This project is the result of the fist lab session in the AMT Course 2016-20117 at HEIG-VD. The goal of this session was to develop and deploy a multi-tiered web application according to the JAVA EE specification.

In our implementation, we developed a simple web application allowing users to create an account and validate their login. This application is made available by a GlassFish web application server and relies on a MySQL database to store and retrieve user's data.

The deployment of the complete setup is provided by Docker, more specifically, by the docker-compose feature, which instantiates the following containers :
* the glassfish server 
* the mysql database
* the phpmyadmin 

contains simple web application allowing users to create an account and validate login.
This application has been developed 


## Repository's content


## The web application

The src folder contains the AMT-Webapp-Login source code MVC java EE app with login/register and permissions. It also implements a JAX-RS REST API for CRUD operations on the users. It uses EJB for the services. The database is stored inside a singleton EJB.

### The presentation tier

### The business tier

#### REST API Documentation

### The data access tier

## Testing

### Postman

### JMeter

## Deployment

### Docker compose

### Quick start

Assuming that you have installed **docker** and **docker-compose** on your machine, move to the `topology-amt` directory and fire up docker-compose to start the glassfish app servers:

```
cd topology-amt
docker-compose build
docker-compose up
```

### Access the webapp

To access the webapp you must follow the link http://127.0.0.1:8080/AMT-Webapp-Login-1.0-SNAPSHOT/ if you're using 'Docker for Mac'/'Docker for PC' or http://192.168.99.100:8080/AMT-Webapp-Login-1.0-SNAPSHOT/ if you are using the Docker Machine.

### Access the administration console of GlassFish

The administration console is accessible at http://127.0.0.1:4848 if you're using 'Docker for Mac'/'Docker for PC' or http://192.168.99.100:4848 if you are using the Docker Machine.
