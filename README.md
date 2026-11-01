# Domain-Driven Design Workshop

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
