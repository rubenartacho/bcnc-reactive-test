# BCNC Software developer test asignment.

## Overview
Test project for Lead Java developer position application at BCNC.

## How to run
[Maven](https://maven.apache.org/) is needed to build the application. 
### Run the application
To run the application from the command line go to the main folder and type.
```shell
 mvn spring-boot:run
 ```
### Compile the application
To  compile the application from the command line go to the main folder and type.
```shell
 mvn package
 ```
This will generate a .jar file inside ./target folder that can be run simply by typing the following.
```shell
 java -jar FILENAME.jar
 ```
### Create a Docker image
To create a Docker image go to the main folder and type.
```shell
 mvn spring-boot:build-image
 ```

## Design decisions
* The application implements Hexagonal Architecture
* It's coded using the Reactive programing paradigm. 
* The API uses PathVariables for parameter input
```
http://host:port/brand/{brandId}/product/{productId}/appDate/{applicationDate}
```
* All dates are ISO format ex. 2020-06-14T21:00:00.000Z 
* Endpoints return application/json bodies.
* If no Price can be found will return a null object .
```json
{"brandId":0,"startDate":null,"endDate":null,"priceList":0,"productId":0,"price":null}
```
* Using R2DBC (Reactive DB non blocking, event driven IO) instead of JPA/Hibernate as currently Hibernate uses blocking IO and will negate the reactive programming benefits heavily impacting performance.

### Hexagonal Architecture
This application has been implemented following the Hexagonal Architecture pattern. 
By using this architecture the domain logic remains decoupled from its clients and its data backend.
Changes in the clients and in the data backend can be performed as long as a new inbound or outbound ports are implemented.

#### Domain isolation
Domain isolation and decoupling has been achieved by the following means:
* Using the Adapter pattern between Controllers, Services and Repositories. This way it's easy to change clients or data backends if needed.
```java
/**
 * This is the inbound port. This interface acts as an adapter for accessing the business logic.
 */
public interface PriceServiceAdapter {
    Mono<PriceDTO> getActualPriceForDate(String applicationDate, long productId, long brandId);

}
```
```java
/**
 * This class acts as an Adapter for accessing Price's business logic. It handles conversion between DTO's and domain entities and decouples
 * business logic from it's clients
 */
@Component
public class PriceServiceAdapterImpl implements PriceServiceAdapter{
    @Autowired
    PriceService priceService;

    @Autowired
    PriceDTOMapper priceDTOMapper;

    @Override
    public Mono<PriceDTO> getActualPriceForDate(String applicationDate, long productId, long brandId) {
        return priceService.getActualPriceForDate(OffsetDateTime.parse(applicationDate), productId, brandId)
                .map(priceDTOMapper::getFromDOM);
    }
}

```
```java
/**
 * This is the outbound port. This interface acts as an adapter for accessing the data backend.
 */
public interface PriceRepositoryAdapter {

    Flux<Price> getPricesForDate(OffsetDateTime applicationDate, long productId,long brandId);

}

```
```java
/**
 * This class acts as an Adapter for accessing Price's data backend. It handles conversion between DAO's and domain entities and decouples data access
 * from business logic.
 */
@Repository
public class PriceRepositoryAdapterImpl implements PriceRepositoryAdapter
{
    @Autowired
    ReactivePriceRepository reactivePriceRepository;

    @Autowired
    PriceDAOMapper priceDAOMapper;

    @Override
    public Flux<Price> getPricesForDate(OffsetDateTime applicationDate, long productId, long brandId) {
        return reactivePriceRepository.findPricesForDate(applicationDate,productId,brandId)
                .map(priceDAOMapper::getFromDAO);

    }
}
```
* Using DAO and DTO entities so domain entities remain inside the domain.

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


### Other Patterns used
* The Actual Price Computing algorithm has been implemented using a combination of Factory and Strategy patterns. This way the behaviour of the algorithm can be changed at any time allowing for great flexibility.
```java
/**
 * This is the interface for a Strategy pattern. This will enable the runtime exchanging of the actual price computing algorithm.
 */
public interface ComputeActualPriceStrategy {

    /**
     * Will get the actual Price from a given List
     * @param prices The Prices list
     * @return The actual Price
     */
    Price getActualPriceFromList(List<Price> prices);

}
```

```java
/**
 * This factory makes it easy to get a concrete ComputeActualPrice implementation at runtime.
 */
@Component
public class ComputeActualPriceFactory {

    Logger logger = LoggerFactory.getLogger(ComputeActualPriceFactory.class);

    @Autowired
    Map<String,ComputeActualPriceStrategy> computeActualPriceStrategyMap;

    public ComputeActualPriceStrategy getComputeActualPriceStrategy(String type){

        ComputeActualPriceStrategy computeActualPriceStrategy = computeActualPriceStrategyMap.get(type);
        if(computeActualPriceStrategy == null){
            logger.warn("Unable to find ComputeActualPriceStrategy type : {} falling back to default computeActualPriceByPriority", type);
            return computeActualPriceStrategyMap.get("computeActualPriceByPriority");
        }
        return computeActualPriceStrategy;
    }

}

```

```java
/**
 * This implementation will pick the highest priority price among all prices from a given List
 * It's also the default implementation.
 */
@Component
public class ComputeActualPriceByPriority implements ComputeActualPriceStrategy{

    @Override
    public Price getActualPriceFromList(List<Price> prices) {

        Price price = new Price();
        int maxPriority = -1;
        for ( Price p : prices ) {
            if(p.getPriority()> maxPriority){
                maxPriority = p.getPriority();
                price = p;
            }
        }

        return price;
    }
}
```
* The algorithm can be selected by the following property in application.properties
```properties
actual.price.algorithm=computeActualPriceByPriority
```
### Performance considerations
* Used Reactive Programming Paradigm (discussed before).
* Hardcoded DAO and DTO mappers instead of using a mapping library as manual implementation tends to perform better (no reflection, no framework overhead, etc.). Some mapping frameworks perform close to manual implementation (ex. Mapstruct). 

### More Info
Feel free to check the comments inside the code for more info.
