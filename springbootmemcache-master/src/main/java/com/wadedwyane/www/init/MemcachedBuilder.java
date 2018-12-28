package com.wadedwyane.www.init;

import com.wadedwyane.www.config.XMemcachedProperties;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.IOException;

@Configuration
public class MemcachedBuilder {

    private static Logger logger = LoggerFactory.getLogger(MemcachedBuilder.class);

    @Resource
    private XMemcachedProperties properties;

    //加上bean注解启动的时候,构建好的直接注入到Spring容器中,在后面使用的类中,直接注入MencachedClient
    @Bean
    public MemcachedClient getMemcachedClient() {
        MemcachedClient client = null;
        try {
            MemcachedClientBuilder builder = new
                    XMemcachedClientBuilder(AddrUtil.getAddresses(properties.getServers()));
            builder.setConnectionPoolSize(properties.getPoolSize());
            builder.setOpTimeout(properties.getOpTimeOut());
            client = builder.build();
        }catch (IOException e) {
            logger.error("init memcachedclient failed", e);
        }
        return client;
    }
}
