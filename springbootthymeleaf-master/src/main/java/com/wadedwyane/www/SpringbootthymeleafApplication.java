package com.wadedwyane.www;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ProtocolHandler;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootthymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootthymeleafApplication.class, args);
    }

    /**
     * TomcatServletWebServerFactory()主要是解决文件上传大于10M出现连接重置的问题,此异常内容GlobalException也捕获不到.
     * @return
     */
    @Bean
    public TomcatServletWebServerFactory tomcatEmbeded() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {
                    AbstractHttp11Protocol protocolHandler = (AbstractHttp11Protocol) connector.getProtocolHandler();
                    protocolHandler.setMaxSwallowSize(-1);
                }
            }
        });
        return factory;
    }

}

