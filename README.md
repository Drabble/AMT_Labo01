# AMT-Phase_3-Drabble-Serneels

## Introduction

This repo contains a MVC java EE app with login/register and permissions. It also implements a JAX-RS REST API for CRUD operations on the users. It uses EJB for the services. The database is stored inside a singleton EJB.

## Quick start

Assuming that you have installed **docker** and **docker-compose** on your machine, move to the `topology-amt` directory and fire up docker-compose to start the glassfish app servers:

```
cd topology-amt
docker-compose build
docker-compose up
```

## Access the webapp

To access the webapp you must follow the link http://127.0.0.1:8080/AMT-Webapp-Login-1.0-SNAPSHOT/ if you're using 'Docker for Mac'/'Docker for PC' or http://192.168.99.100:8080/AMT-Webapp-Login-1.0-SNAPSHOT/ if you are using the Docker Machine.

## Access the administration console of GlassFish

The administration console is accessible at http://127.0.0.1:4848 if you're using 'Docker for Mac'/'Docker for PC' or http://192.168.99.100:4848 if you are using the Docker Machine.
