#INTEGRITY ❤ BANK

This is a simple representation of bank

## Table of contents 
* [Description](#description)
* [Prerequisites](#prerequisites)
* [Technologies used](#technologies-used)
* [Deployment](#deployment)
* [Author](#author)


## Description

The bank has page with all clients. You can see clients ID's, clients names, clients ages, clients addresses. 
You can add a new client.
You can see accounts of client and can add new one.
Clients can have multiple accounts. You can send money from/to accounts



### Prerequisites

To run this project you need to install next software: 
* [Java 13](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) - 
Development environment 
* [Maven](https://maven.apache.org/) - Dependency Management
* [Tomcat](http://tomcat.apache.org/) - Web Server
* [MySQL](https://www.mysql.com/) - Database

## Technologies used

*  spring-boot-starter-web 2.2.5
*  spring-boot-starter-data-jpa 2.2.5
*  spring-boot-starter-tomcat 2.2.5
*  spring-boot-starter-thymeleaf 2.2.5
*  mysql-connector-java 8.0.19
*  lombok 1.18.12

## Deployment

Add this project to your IDE as Maven project.

Add Java SDK 13 in project structure.

Configure Tomcat:
- Add artifact
- Add Java SDK 13


To work with MySQL you need to:
- Create schema (use sql requests in **src/main/resources/init_db.sql** )
- Use your user and password from MySql DB on 5 and 6 lines of **src/main/resources/application.properties**.

Run the project:
Main page is at URL: .../{context_path}/clients

If you want to start application from command line:
Start command line mode, go to the folder with pom.xml and enter the mvn clean package command
Maven will generate an executable jar file called integritybank-0.0.1-SNAPSHOT.war
Go to the cd target folder
Then run the jar file: java -jar integritybank-0.0.1-SNAPSHOT.war
Go to the browser at http://localhost:8080/clients
Enjoy to test everything)
## Author
 [Ruslan Simakov](ua667766706@gmail.com)
If you have questions - feel free to write me.
Have a nice day))

