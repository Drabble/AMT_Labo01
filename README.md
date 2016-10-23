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


## REST API Documentation

The base url of our api is
````
/api
````

The following HTTP methods can then be used to interract with our API

### GET	

To obtain a JSON object containing the list of every registered user
````
/api/users
````
To obtain a JSON object containing the user corresponding to a precise id ({userId})
````
/api/users/{userId}
````

### POST	

To register a new user 
````
/api/users
````
The response will contain the newly created user's id

### PUT	

To update an existing user by specifying his id ({userId})

````
/api/users/{userId}
````
The response will contain the updated user's id

### DELETE

To delete an existing user by specifying his id ({userId})

````
/api/users/{userId}
````
The response will contain the deletes user's id


## Deployment

### Docker compose

The following docker-compose.yml file is used to bring up the whole set up:

```version: '2'
services:
  glassfish:
    build: ../images/glassfish
    links:
     - mysql:db
    ports:
     - "8080:8080"
     - "4848:4848"
  mysql:
    build: ../images/mysql
    environment: 
      - MYSQL_ROOT_PASSWORD=adminpw
    ports:
      - "3306:3306"
  phpmyadmin:
    build: ../images/phpmyadmin 
    environment: 
      - MYSQL_ROOT_PASSWORD=adminpw    
    ports:
      - "6060:80"
    links:
      - mysql:db
```

It instantiates these three docker images:

 * The glassfish application server
 * The mysql database
 * The phpmyadmin 


### Quick start

Assuming that you have installed **docker** and **docker-compose** on your machine, move to the **topology-amt** directory and fire up docker-compose to start the glassfish app servers, the mysql database and the phpmyadmin image:

```
cd topology-amt
docker-compose build
docker-compose up
```

### Access the webapp

To access the webapp you must follow the link http://127.0.0.1:8080/AMT-Webapp-Login-1.0-SNAPSHOT/ if you're using 'Docker for Mac'/'Docker for PC' or http://192.168.99.100:8080/AMT-Webapp-Login-1.0-SNAPSHOT/ if you are using the Docker Machine.

### Access the administration console of GlassFish

The administration console is accessible at http://127.0.0.1:4848 if you're using 'Docker for Mac'/'Docker for PC' or http://192.168.99.100:4848 if you are using the Docker Machine.

The default glassfish admin credentials are:
User Name:	admin	
Password: glassfish

## Testing

### Postman

The **postman_requests** folder located in the root of our repository contains a Collection of Postman requests that can be used to test our API.

To use these requests, you have to set a Postman environment variable named URL with the correct path ot your setup, for example:

http://127.0.0.1:8080/AMT-Webapp-Login-1.0-SNAPSHOT

### JMeter

The **jmeter_test** folder located in the root of our repository contains a JMeter Test Plan


## Known issues

We have noticed a bug, probably coming from Glassfish, which provokes an HTTP internal server error on the first execution of every HTTP query, be it from the client browser or from Postman. A refresh in the browser or a re-execution in Postman then produces the expected result.