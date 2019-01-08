package com.wadedwyane.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:config/data-source.properties"})
public class DataResourceConfig {

    @Autowired
    private Environment env;

    @Bean(name = "datasource")
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName(env.getProperty("spring.datasource.driverClassName").trim());
        builder.url(env.getProperty("spring.datasource.url").trim());
        builder.username(env.getProperty("spring.datasource.username").trim());
        builder.password(env.getProperty("spring.datasource.password").trim());
        return builder.build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
