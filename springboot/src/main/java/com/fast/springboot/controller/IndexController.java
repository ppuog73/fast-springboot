package com.fast.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author i666
 * @date 2026/8/20 20:07
 * @description 首页控制器，用来处理根路径请求
 */

@RestController //告诉spring这是一个Rest API控制器，用来处理请求，会自动把返回值转换成json格式
@RequestMapping("/") //告诉spring，这个控制器处理的请求路径是根路径
public class IndexController {
    @GetMapping //告诉spring，这个方法处理的请求是GET请求，请求路径是根路径
    public String index(){
        //获取当前时间，从默认时区的系统时钟获取当前日期时间。这将查询默认时区的系统时钟以获取当前日期时间
        String time =  LocalDateTime.now().toString();
        return "Hello World!" + time;
    }
}
