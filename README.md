## spring-cloud-example ##

spring-cloud-example是作者在学习Spring Boot过程中的所有demo的一个集合。

### springbootactivemq-master ###
springbootactivemq-master是在springboot快速引入ActiveMQ的demo。

ActiveMQ是分布式系统中重要的消息队列中间件，主要解决应用耦合、异步消息、流量削峰等问题。ActiveMQ实现了JMS规范并在此基础上提供了大量额外的特性，ActiveMQ支持队列和发送两种模式的消息发送。

Spring Boot提供了ActivieMQ组件spring-boot-starter-activemq，用来支持ActiveMQ在Spring Boot体系中的使用。

### springbootemail-master ###
springbootemail-master是在Spring Boot中开发邮件系统的demo。

该demo主要包含如何配置pom.xml、application.properties等文件，如何发送文本邮件、富文本邮件等。

### springbootmemcache-matser ###
springbootmemcache-matser是在Spring Boot中快速集成缓存中间件MemCache的demo。

Memcache是一个自由、开放、高性能的内存对象缓存系统。简单来说，Memcache就是一个简单的基于分布式的key-value缓存系统。

### springbootmybatis-master ###
springbootmybatis-master是在Spring Boot中快速集成MyBatis的demo。

MyBatis作为现如今最流行的ORM框架之一。Spring Boot为它提供了快速集成的组件包mybatis-spring-boot-starter。它主要提供了两种解决方案，一种是XML配置，一种是使用注解。两种方式在demo中都有涉及到。

### springbootquartz-master ###
springbootquartz-master是在Spring Boot中快速集成Quartz的demo。

Quartz作为一个实现复杂业务、定时任务的开源作业调度框架和任务管理系统。作为目前Java体系中最完善的定时方案，我们将提供如何快速集成quartz的方案。

### springbootrabbitmq-master ###
springbootrabbitmq-master是在Spring Boot中快速集成RabbitMQ的demo。

RabbitMQ作为一款高效的消息队列组件，是AMQP(advanced message queue protocol)的实现。它内部使用erlang语言实现支持多种客户端，多用于分布式系统中的存储和转发消息。

### springbootredis-master ###
springbootredis-master是在Spring Boot中快速集成Redis高性能缓存系统的demo。

Redis是目前应用最广泛的分布式缓存中间件，相比Memcache，Redis支持更多的数据结构和更为丰富的数据操作。在这个demo中，我们将会学习到如何快速集成Redis。

### springbootredissession-matser ###
springbootredissession-matser是利用Spring Boot和Redis实现Session共享的demo。

目前主流的Session管理主要有两种方案：Session复制、Session集中存储。
然而在微服务架构中。往往需要N个服务端来共同支持服务，所以采用Session集中存储，因此使用Redis来集中存储Session就可以达到Session共享的目的。

### springbootsecurity-master ###
springbootsecurity-master是在Spring Boot中快速集成Security来进行安全控制的demo。

Spring Security是基于Spring的安全访问控制解决方案的框架。Spring Boot提供了集成Spring Security的组件spring-boot-starter-security，方便我们快速上手。

### springbootswagger-matser ###
springbootswagger-matser是在Spring Boot中快速集成Swagger的demo。

Swagger是一系列RESTful API的工具，通过Swagger可以获得项目的一种交互式文档，客户端快速生成文档的功能。Spring Boot集成Swagger可以帮我们用注解来生成API文档，大大减少了我们开发中编写文档、调试的工作量。

### springbootthymeleaf-master ###
springbootthymeleaf-master是在Spring Boot中快速集成Thymeleaf的demo。

Thymeleaf是面向Web和现代服务端Java的模板引擎。能够处理HTML/XML/js/CSS甚至纯文本。Spring Boot体系中推荐使用Thymeleaf作为前端页面模板。并且Spring Boot2.0支持Thymeleaf3.0,性能提升幅度很大。

### springbootjpa-matser ###
springbootjpa-matser是在Spring Boot中快速集成Spring Data JPA的demo。

Spring Data JPA是Spring基于ORM框架、JPA规范提出的一套JPA框架，主要方便开发者用极简的代码实现对数据的访问和操作。方便开发者在Spring Boot中使用JPA。让开发者不用花太多时间在DAO的处理上，基本所有的CRUD操作都依赖于Spring Data JPA来完成。



