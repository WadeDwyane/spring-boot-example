package com.wadedwyane.www.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "memcached")
public class XMemcachedProperties {

    private String servers;
    private int poolSize;
    private long opTimeOut;

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public long getOpTimeOut() {
        return opTimeOut;
    }

    public void setOpTimeOut(long opTimeOut) {
        this.opTimeOut = opTimeOut;
    }
}
