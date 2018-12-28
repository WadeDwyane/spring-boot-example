package com.wadedwyane.www.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//使用注解配置session的过期时间,使用RedisSession后,配置文件中设置的失效时间不在生效
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {


}
