# Domain-Driven Design Workshop

## Origin
- Original project: https://github.com/yanaga/scars-from-the-journey by Edson Yanaga
- Related talk (likely): [Effective and Clean Java Code? Tips and Tricks from the Real World](https://www.youtube.com/watch?v=uOrk8mZmjaM), Edson Yanaga, Jfokus 2017

This version has been migrated from:
- WildFly Swarm / Java EE 7 / Java 8 
to 
- [WildFly 42](https://www.wildfly.org/downloads/) / Jakarta EE 10 / Java 25.



### His Favorites
- JavasLang now vavr: https://vavr.io/
- Immutables: https://immutables.github.io/


## Requirements:
- Git
- Java 25
- A Java IDE
- Maven 3.9+

## Stack
- WildFly 42 packaged as a [Bootable JAR](https://docs.wildfly.org/bootablejar/) (`wildfly-maven-plugin`)
- Jakarta EE 10 (CDI, Faces, Persistence) with PrimeFaces 16
- Hibernate 7 (provided by WildFly), QueryDSL 7 ([OpenFeign fork](https://github.com/OpenFeign/querydsl))
- H2 in-memory database (`java:jboss/datasources/ExampleDS`), schema and data created by Flyway at startup

## Build and run

```bash
mvn clean package
java -jar target/demo-bootable.jar
```

Then open http://127.0.0.1:8080/
