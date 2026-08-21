package com.fast.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author i666
 * @date 2026/8/21 21:49
 * @description 读取项目相关配置，专门负责读取application.yml文件中的配置信息
 */
@Component //告诉spring这是一个组件，放到容器里进行管理，方便全局调用
@ConfigurationProperties(prefix = "springboot") //核心注解：告诉spring，这个组件的配置信息是从application.yml文件中的springboot开头的配置信息
public class FastConfig {

    //编写属性，对应application.yml文件中的配置信息
    // 文件上传路径配置
    private static String profile;

    public static String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        FastConfig.profile = profile;
    }
}
