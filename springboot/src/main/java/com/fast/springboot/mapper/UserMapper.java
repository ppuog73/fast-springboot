package com.fast.springboot.mapper;

import com.fast.springboot.domain.User;

/**
 * @author i666
 * @date 2026/8/22 09:24
 * @description TODO
 */
public interface UserMapper {
    /**
     * 根据用户名称查询用户信息
     * @param username 用户名称
     * @return 用户信息
     */
    public User selectUserByUsername(String username);
}
