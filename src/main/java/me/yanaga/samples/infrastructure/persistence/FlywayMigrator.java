package me.yanaga.samples.infrastructure.persistence;

import org.flywaydb.core.Flyway;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import javax.sql.DataSource;

/**
 * Runs the Flyway migrations (src/main/resources/db/migration) when the application starts.
 * Replaces the former WildFly Swarm "flyway" fraction.
 */
@ApplicationScoped
public class FlywayMigrator {

    @Resource(lookup = "java:jboss/datasources/ExampleDS")
    private DataSource dataSource;

    void migrate(@Observes @Initialized(ApplicationScoped.class) Object event) {
        Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .load()
                .migrate();
    }
}
