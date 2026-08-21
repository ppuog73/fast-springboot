package com.fast.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

/**
 * @author i666
 * @date 2026/8/21 22:00
 * @description 资源处理配置类，用来处理静态资源请求，配置跨域访问规则
 * 配置之后，允许所有域名访问，允许所有方法访问，允许所有头信息访问，允许所有路径访问
 * 允许外部域名访问本系统的所有资源，例如：图片，视频，音频，文档，网页等
 */
@Configuration //告诉spring这是一个配置类，启动的时候要读这里的配置
public class ResourceConfig implements WebMvcConfigurer {

    /**
     * 重写addResourceHandlers方法，配置静态资源处理规则
     * @param registry 资源处理器注册器
     * 告诉spring当用户访问某个路径时，应该去服务器的哪个路径下找资源
     */
    @Override
    public void addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry registry) {
        // 配置静态资源处理规则
        // 当用户访问 /profile/** 路径时，应该去服务器的 file + FastConfig.getProfile() + / 路径下找资源
        // 例如：用户访问 /profile/avatar.png 路径时，应该去服务器的 file + FastConfig.getProfile() + /avatar.png 路径下找资源
        registry.addResourceHandler("/profile/**")
                //“file：”的意思是这是本地文件系统的路径，后面的“+”号是字符串拼接的意思
                //FastConfig.getProfile()是一个静态方法，返回的是一个字符串，代表的是文件上传的路径
                //“/”是文件系统的路径分隔符，代表的是根目录
                //如果不要“file：”，那么就会变成这样：FastConfig.getProfile() + /，会直接报错
                //如果file写错了，与西戎本地路径的名字不一样，那也会报错，这里怎么写，取决于在application.yml文件中配置的文件上传路径
                .addResourceLocations("file:" + FastConfig.getProfile() + "/");
    }

    /**
     * 完成跨域配置规则
     * 告诉spring当用户访问某个路径时，应该允许哪些域名访问
     * 这里的规则是：允许所有域名访问，允许所有方法访问，允许所有头信息访问，允许所有路径访问
     * 这样就可以跨域访问了
     * 跨域访问：指的是浏览器从一个域名的网页去请求另一个域名的资源
     * 例如：浏览器从www.360safe.com网页去请求www.baidu.com的资源
     * 这样就可以跨域访问了
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        //创建一个跨域配置对象，设置允许的域名，方法，头信息，路径
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //设置允许的域名，*代表允许所有域名访问
        //如果是多个域名，可以用逗号隔开，例如：http://www.baidu.com,http://www.360safe.com
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));

        //允许域名携带那些请求头信息，请求头信息是指的是请求的一些信息，例如：token，cookie，accept，content-type等
        //如果是多个请求头信息，可以用逗号隔开，例如：token,cookie,accept,content-type
        //corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));

        //允许域名携带那些方法，方法是指的是请求的方法，例如：GET，POST，PUT，DELETE等
        //如果是多个方法，可以用逗号隔开，例如：GET,POST,PUT,DELETE
        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));

        //允许域名携带那些路径，路径是指的是请求的路径，例如：/user，/user/1，/user/2等
        //如果是多个路径，可以用逗号隔开，例如：/user，/user/1，/user/2
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));

        //是否允许携带凭证，凭证是指的是请求的一些信息，例如：token，cookie，accept，content-type等
        //如果允许携带凭证，那么就需要在请求头信息中添加一些信息，例如：token，cookie，accept，content-type等
        //如果不允许携带凭证，那么就不需要在请求头信息中添加任何信息
        //这个和上面的setAllowedHeaders方法是互斥的，不能同时设置
        //如果同时设置了，那么就会报错
        corsConfiguration.setAllowCredentials(true);

        //设置预检请求的缓存时间，单位是秒
        //预检请求是指的是浏览器在发送正式请求之前，先发送一个预检请求，用来检查是否允许发送正式请求
        //如果预检请求的缓存时间为0，那么就会每次都发送预检请求，这样会影响性能
        //比如浏览器在发送put、delete、post请求的时候，都会先发送一个Options预检请求，用来检查是否允许发送正式请求
        corsConfiguration.setMaxAge(1800L);

        //创建基于URL的CORS配置源
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        //注册配置，对所有路径应用上面的跨域规则
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        //返回CORS配置源
        return urlBasedCorsConfigurationSource;
    }
}
