# AMT Labo 1 : Discovering Java EE 

## Introduction

This project is the result of the fist lab session for Antoine Drabble and Guillaume Serneels in the AMT Course 2016-2017 at HEIG-VD. The goal of this session was to develop and deploy a multi-tiered web application according to the JAVA EE specification.

In our implementation, we developed a simple web application allowing users to create an account and validate their login. This application is made available by a GlassFish web application server and relies on a MySQL database to store and retrieve user's data.

The deployment of the complete setup is provided by Docker, more specifically, by the docker-compose feature, which instantiates the following containers :
* the glassfish server 
* the mysql database
* the phpmyadmin 



## The web application

The **src** folder contains the source code of our application, AMT-Webapp-Login. It is an MVC java EE app with login/register and permissions. It implements a JAX-RS REST API for CRUD operations on the users. It uses a Stateles Session Bean EJB for the main user service and to interact with the mysql database. 

The html template used is grayscale from startbootstrap.com
https://startbootstrap.com/template-overviews/grayscale/


## REST API Documentation

The base url of our api is
```
/api
```

The following HTTP methods can then be used to interract with our API

### GET	

To obtain a JSON object containing the list of every registered user
```
/api/users
```
To obtain a JSON object containing the user corresponding to a precise id ({userId})
```
/api/users/{userId}
```

### POST	

To register a new user 
```
/api/users
```
The response will contain the newly created user's id

### PUT	

To update an existing user by specifying his id ({userId})

```
/api/users/{userId}
```
The response will contain the updated user's id

### DELETE

To delete an existing user by specifying his id ({userId})

```
/api/users/{userId}
```
The response will contain the deletes user's id


## Deployment

### Docker compose

The **topology-amt** folder contains the docker-compose.yml file which is used to bring up the whole set up:

```
version: '2'
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

These docker images are stored in the **images** folder located at the root of our repository. 

The process instantiates these three docker images:

 * The glassfish application server, located in the **glassfish** folder
 * The mysql database, located in the  **mysql** folder
 * The phpmyadmin to access the database, located in the **phpmyadmin** folder

Within the **mysql** image folder there is a **data** folder containing two sql files 

* **a_webapp_schema.sql** to create the database schema
* **b_webapp_data.sql** to insert data in our database

The Dockerfile of this image copies these two file to the **/docker-entrypoint-initdb.d/** within the mysql container. All the .sql content of this file is automatically executed when the database container is instantiated.

The username for the MySQL server is root and the password is adminpw. You can also use this login to connect on the phpmyadmin server which can be accessed on the following address : http://{docker_ip}:6060.

Within the **glassfish** folder there is an **apps** folder. This is where we put the .war file of our web application. The Dockerfile of the glassfish server specifies that this .war file is copied to the **autodeploy** folder of the application server.



### Quick start

Assuming that you have installed **docker** and **docker-compose** on your machine, move to the **topology-amt** directory and fire up docker-compose to start the glassfish app servers, the mysql database and the phpmyadmin image:

```
cd topology-amt
docker-compose build
docker-compose up

```

### Access the webapp

To access the webapp you must follow the link http://127.0.0.1:8080/AMT-Webapp-Login-1.0-SNAPSHOT/ if you're using 'Docker for Mac'/'Docker for PC' or http://192.168.99.100:8080/AMT-Webapp-Login-1.0-SNAPSHOT/ if you are using the Docker Machine.

### Logging into the webapp

For testing purposes, four different user account are pre-defined in our infrastucture:

username | password
-------- | --------
antoine  | 1234
guilaume | 4321
olivier  | 1111
laurent  | 2222

Other user accounts can be created using the **register** feature.

After logging in, a list of every registered users is displayed on the users home page.

### Access the administration console of GlassFish

The administration console is accessible at http://127.0.0.1:4848 if you're using 'Docker for Mac'/'Docker for PC' or http://192.168.99.100:4848 if you are using the Docker Machine.

The default glassfish admin credentials are:

* User Name:	admin	
* Password: 	glassfish

## Testing

We have manually tested every success and error cases on the REST API with postman as well as on the Google Chrome web browser and every test succeeded.

### Postman

The **postman_requests** folder located in the root of our repository contains a Collection of Postman. We have created a request for every urls of our REST API. You can edit the id of the user for the DELETE, PUT and GET requests directly in the url. You can edit the POST data sent inside the body of the request for the create and update requests.

To use these requests, you have to set a Postman environment variable named URL with the correct path of your setup, for example:

http://127.0.0.1:8080/AMT-Webapp-Login-1.0-SNAPSHOT or http://192.168.99.100:8080/AMT-Webapp-Login-1.0-SNAPSHOT

### JMeter

The **jmeter_test** folder located in the root of our repository contains two jmeter test plans that we used to test the user creation (POST) of our apllication:

* webapp_testplan_POST_create_different_users.jmx

This test plan generates 10 unit groups of 20 users, each of them executes an HTTP POST request to create a new user using a randomly generated UUID as username.

When the test plan is run, each request results in an **HTTP 201 Created** Response

* webapp_testplan_POST_create_same_users.jmx

This test plan generates 10 unit groups of 20 users, each of them executes an HTTP POST request to create a new user using the same username "utilisateur".

When the test plan is run, the first request results in an **HTTP 201 Created** Response. All the following ones result in an **HTTP 409 Conflict** Response.


## Known issues

We have noticed a bug, probably coming from Glassfish, which sometimes provokes an HTTP internal server error (Code 500) on the first execution of a HTTP query, be it from the client browser or from Postman. A refresh in the browser or a re-execution in Postman then produces the expected result. This issue was reviewed in class with Mr. Liechti, no solution has been found yet.
