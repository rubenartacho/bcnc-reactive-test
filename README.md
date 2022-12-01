# BCNC Software developer test asignment.

## Overview
Test project for Lead Java developer position application at BCNC.

## How to run
[Maven](https://maven.apache.org/) is needed to build the application. 
###Run the application
To run the application from the command line go to the main folder and type.
```sh
 $mvn spring-boot:run
 ```
###Compile the application
To  compile the application from the command line go to the main folder and type.
```sh
 $mvn package
 ```
This will generate a .jar file inside ./target folder that can be run simply by typing the following.
```sh
 $java -jar FILENAME.jar
 ```
###Create a Docker image
To create a Docker image go to the main folder and type.
```sh
 $mvn spring-boot:build-image
 ```

## Design decisions
For this application 

### Hexagonal Architecture

#### Domain isolation

#### Adapters used

#### DAO and DTO usage

### Reactive programming

#### Why reactive?

#### Need more info?

### Performance considerations

### Patterns used

### Technologies

## More Info
