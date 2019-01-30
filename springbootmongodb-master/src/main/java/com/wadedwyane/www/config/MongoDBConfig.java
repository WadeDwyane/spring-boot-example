package com.wadedwyane.www.config;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.wadedwyane.www.properties.MultiMongoDBProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoDBConfig {

    @Autowired
    MultiMongoDBProperties multiMongoDBProperties;

    @Bean
    @Primary
    public MongoDbFactory primary(MultiMongoDBProperties mongoProperties) {
        MongoClient client = new MongoClient(new MongoClientURI(mongoProperties.getPrimary().getUri()));
        return new SimpleMongoDbFactory(client, mongoProperties.getPrimary().getDatabase());
    }

    @Bean
    public MongoDbFactory secondary(MultiMongoDBProperties mongoProperties) {
        MongoClient client = new MongoClient(new MongoClientURI(mongoProperties.getSecondary().getUri()));
        return new SimpleMongoDbFactory(client, mongoProperties.getSecondary().getDatabase());
    }

    @Primary
    @Bean(name = "primaryMongoTemplate")
    public MongoTemplate primaryMongoTemplate() {
        return new MongoTemplate(primary(multiMongoDBProperties));
    }

    @Bean
    @Qualifier("secondMongoTemplate")
    public MongoTemplate secondMongoTemplate() {
        return new MongoTemplate(secondary(multiMongoDBProperties));
    }


}
