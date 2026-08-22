package com.fast.springboot.service.impl;

import com.fast.springboot.domain.User;
import com.fast.springboot.mapper.UserMapper;
import com.fast.springboot.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author i666
 * @date 2026/8/22 09:04
 * @description 用户服务实现类，用来实现用户服务的方法
 * 比如：查询用户、添加用户、删除用户、修改用户等
 * 这个类是UserService接口的实现类，用来实现UserService接口中定义的方法
 */
@Service //告诉spring这是一个服务类，用来处理业务逻辑，会自动把这个类注册到spring容器中
public class UserServiceImpl implements UserService {

    //注入UserMapper
    // 为什么要注入UserMapper？
    // 因为在UserServiceImpl中需要使用UserMapper来查询用户信息，所以需要注入UserMapper
    // 为什么要使用@Resource？
    // 因为@Autowired是按照类型注入的，而@Resource是按照名称注入的，这样可以避免注入的是同一个UserMapper，
    // 因为UserMapper是一个接口，spring容器中只有一个UserMapper的实现类，所以可以使用@Resource来注入UserMapper
    @Resource //告诉spring这是一个资源，用来注入UserMapper，会自动把UserMapper注入到这个类中，这个注解等同于Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
