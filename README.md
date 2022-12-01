# BCNC Software developer test asignment.

## Overview
Test project for Lead Java developer position application at BCNC.

## How to run
[Maven](https://maven.apache.org/) is needed to build the application. 
### Run the application
To run the application from the command line go to the main folder and type.
```sh
 mvn spring-boot:run
 ```
### Compile the application
To  compile the application from the command line go to the main folder and type.
```sh
 mvn package
 ```
This will generate a .jar file inside ./target folder that can be run simply by typing the following.
```sh
 java -jar FILENAME.jar
 ```
### Create a Docker image
To create a Docker image go to the main folder and type.
```sh
 mvn spring-boot:build-image
 ```

## Design decisions

### Hexagonal Architecture
This application has been implemented following the Hexagonal Architecture pattern. 
By using this architecture the domain logic remains decoupled from its clients and its data backend.
Changes in the clients and in the data backend can be performed as long as a new inbound or outbound ports are implemented.

#### Domain isolation

#### Adapters used

### Reactive programming
This application uses the Reactive Programming paradigm.

* Reactive programming is a programming paradigm that promotes an asynchronous, non-blocking, event-driven approach to data processing.
* The term, “reactive,” refers to programming models that are built around reacting to change — network components reacting to I/O events, UI controllers reacting to mouse events, and others.
* In that sense, non-blocking is reactive, because, instead of being blocked, we are now in the mode of reacting to notifications as operations complete or data becomes available.
* Reactive systems have certain characteristics that make them ideal for low-latency, high-throughput workloads
#### Why reactive?
* Small thread number. Move away from the thread per request model and can handle more requests with a low number of threads.
* Smaller memory footprint.
* Better responsiveness.
* Prevent threads from blocking while waiting for I/O operations to complete.
* Makes it easy to do parallel calls.
* Less context switching between threads so improved performance.
* Better resource usage.
* Can handle higher workloads with the same resources (as long as the use case can benefit from it).
#### Reactive programming recommended use cases
* I/O Bound workloads (Disk access, DB access, Network queries, Calling microservices, etc.). In those cases there are great benefits using reactive programming. This application fits inside this use case.
* Heavy backpressure. Lots of queries, lots of clients, etc.
* Need for fast responsiveness.
#### Spring WebFlux
* In Spring WebFlux (and non-blocking servers in general), it is assumed that applications do not block. Therefore, non-blocking servers use a small, fixed-size thread pool (event loop workers) to handle requests.
* “To scale” and “small number of threads” may sound contradictory but to never block the current thread (and rely on callbacks instead) means that you do not need extra threads, as there are no blocking calls to absorb.
* On a “vanilla” Spring WebFlux server (for example, no data access nor other optional dependencies), you can expect one thread for the server and several others for request processing (typically as many as the number of CPU cores). Servlet containers, however, may start with more threads (for example, 10 on Tomcat), in support of both servlet (blocking) I/O and servlet 3.1 (non-blocking) I/O usage.
* The reactive WebClient operates in event loop style. So you can see a small, fixed number of processing threads related to that (for example, reactor-http-nio- with the Reactor Netty connector). However, if Reactor Netty is used for both client and server, the two share event loop resources by default.
* Spring WebFlux is an annotation-based web framework built on [Project Reactor](https://projectreactor.io/)  and provides two main types called Flux and Mono.


### Patterns used

### Technologies
[Project Reactor]()
## More Info
Feel free to check the comments inside the code for more info.
