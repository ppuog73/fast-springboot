package com.fast.springboot.service;

import com.fast.springboot.domain.User;

/**
 * @author i666
 * @date 2026/8/22 09:03
 * @description 用户服务接口，用来定义用户服务的方法
 * 比如：查询用户、添加用户、删除用户、修改用户等
 */
public interface UserService {
    /**
     * 根据用户名查询用户信息，供登录使用
     * @param username 用户名
     * @return 用户信息
     */
    public User selectUserByUsername(String username);
}
