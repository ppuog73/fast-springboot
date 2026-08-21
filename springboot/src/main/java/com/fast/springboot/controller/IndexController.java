package com.fast.springboot.controller;

import com.fast.springboot.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author i666
 * @date 2026/8/20 20:07
 * @description 首页控制器，用来处理根路径请求
 */

@RestController //告诉spring这是一个Rest API控制器，用来处理请求，会自动把返回值转换成json格式
@RequestMapping("/") //告诉spring，这个控制器处理的请求路径是根路径
public class IndexController {
    @GetMapping //告诉spring，这个方法处理的请求是GET请求，请求路径是根路径
    public AjaxResult index(){
        return AjaxResult.error("你出错了").put("错误登录","请输入正确用户密码");
    }
}
