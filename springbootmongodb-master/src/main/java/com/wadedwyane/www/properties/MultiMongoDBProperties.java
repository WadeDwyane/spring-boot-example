package com.wadedwyane.www.properties;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mongodb")
public class MultiMongoDBProperties {

    private MongoProperties primary = new MongoProperties();
    private MongoProperties secondary = new MongoProperties();

    public MongoProperties getPrimary() {
        return primary;
    }

    public void setPrimary(MongoProperties primary) {
        this.primary = primary;
    }

    public MongoProperties getSecondary() {
        return secondary;
    }

    public void setSecondary(MongoProperties secondary) {
        this.secondary = secondary;
    }

}
