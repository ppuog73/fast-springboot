package com.fast.springboot.controller;

import com.fast.springboot.domain.AjaxResult;
import com.fast.springboot.domain.User;
import com.fast.springboot.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author i666
 * @date 2026/8/20 20:07
 * @description 首页控制器，用来处理根路径请求
 */

@RestController //告诉spring这是一个Rest API控制器，用来处理请求，会自动把返回值转换成json格式
@RequestMapping("/") //告诉spring，这个控制器处理的请求路径是根路径
public class IndexController extends BaseController{

    //注入UserService
    @Resource
    private UserService userService;

    @GetMapping //告诉spring，这个方法处理的请求是GET请求，请求路径是根路径
    public AjaxResult index(){
        return AjaxResult.error("你出错了").put("错误登录","请输入正确用户密码");
    }

    @GetMapping("/success") //告诉spring，这个方法处理的请求是GET请求，请求路径是根路径
    public AjaxResult login(){
        //这里直接调用来自BaseController的success方法，返回一个成功的消息
        //为什么是直接调用BaseController的success方法？
        // 因为在子类中可以直接调用父类中的非静态方法，或者写成super.success()
        return super.success().put("成功登录","请输入正确用户密码");
    }

    @GetMapping("/error") //告诉spring，这个方法处理的请求是GET请求，请求路径是根路径
    public AjaxResult logout(){
        //这里直接调用来自BaseController的success方法，返回一个成功的消息
        //为什么是直接调用BaseController的success方法？
        // 因为在子类中可以直接调用父类中的非静态方法，或者写成super.success()
        return super.error().put("登录失败","请输入正确用户密码");
    }

    /**
     * 根据用户名称查询用户信息并返回给前端
     * @param userName 用户名称
     * @return 用户信息
     */
    @GetMapping("/selectUserByUsername/{username}") //告诉spring，这个方法处理的请求是GET请求，请求路径是根路径
    //使用@PathVariable注解，告诉spring，这个参数是从路径中获取的，路径中的{userName}就是这个参数的值
    public AjaxResult getUser(@PathVariable String username){
        User user = userService.selectUserByUsername(username);
        return user!=null?super.success(user):super.error(username+"用户不存在");
    }
}
