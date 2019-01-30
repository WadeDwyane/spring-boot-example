package com.wadedwyane.www.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableConfigurationProperties(MongoDBConfig.class)
@EnableMongoRepositories(basePackages = "com.wadedwyane.www.repository.primary", mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoConfig {
}
