package com.fast.springboot.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

/*
  程序基础配置类
  是整个程序的基础设置中心，相当于整个系统的基础配置文件
  一般都是一些基础的配置，比如数据库连接池、缓存配置、日志配置、安全配置等
  通用的全局的应用设置
  使用@Configuration注解来标识这是一个配置类
 */
/**
 * @author i666
 */
@Configuration //告诉spring这是一个配置类，启动的时候要读这里的配置
@MapperScan("com.fast.**.mapper") //告诉mybatis去哪个包下面找mapper接口
public class ApplicationConfig {

    /**
     * 时区配置bean
     * 解决时间差问题
     */
    @Bean //告诉spring，这个方法返回的对象放到容器中，其它地方要用的话就可以从容器中获取
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(){
        return jacksonObjectMapperBuilder ->
                //设置时区为系统默认时区
                jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
        /*
        理解：
            1.TimeZone.getDefault() 获取系统默认的时区
            2. timeZone(TimeZone.getDefault()) 设置时区为系统默认时区
            3. 流程举例：
                用户发来请求，spring使用该方法解析，jackson看到时间字段
                按照配置的时区来解析时间
                存到数据库中或者返回给前端
         */
    }
}
