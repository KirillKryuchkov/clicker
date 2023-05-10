package ru.nedra.clicker.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfiguration {


    @Bean(value = "postgresContainer", initMethod = "start", destroyMethod = "close")
    public PostgreSQLContainer<?> getPostgresContainer() {
        return new PostgreSQLContainer<>("postgres:latest");
    }

    @Bean
    public DataSource getDatasource( PostgreSQLContainer<?> postgresContainer) {
        return DataSourceBuilder.create()
                .url(postgresContainer.getJdbcUrl())
                .username(postgresContainer.getUsername())
                .password(postgresContainer.getPassword())
                .build();
    }
}
