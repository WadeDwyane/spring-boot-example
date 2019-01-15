package com.wadedwyane.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class DatasourceConfig {

    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName(env.getProperty("spring.datasource.primary.driver-class-name").trim());
        builder.url(env.getProperty("spring.datasource.primary.url").trim());
        builder.username(env.getProperty("spring.datasource.primary.username").trim());
        builder.password(env.getProperty("spring.datasource.primary.password").trim());
        return builder.build();
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName(env.getProperty("spring.datasource.secondary.driver-class-name").trim());
        builder.url(env.getProperty("spring.datasource.secondary.url").trim());
        builder.username(env.getProperty("spring.datasource.secondary.username").trim());
        builder.password(env.getProperty("spring.datasource.secondary.password").trim());
        return builder.build();
    }

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate() {
        return new JdbcTemplate(primaryDataSource());
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate() {
        return new JdbcTemplate(secondaryDataSource());
    }
}
