package com.fast.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author i666
 */
//(exclude = {DataSourceAutoConfiguration.class}) 表示排除了数据源的自动配置，一般都是自己配置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //代表整个后端的启动入口
public class SpringbootApplication {

    //整个Java程序的入口
    public static void main(String[] args) {
        //启动springboot应用
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
