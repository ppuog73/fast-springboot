package com.fast.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author i666
 * @date 2026/8/22 08:55
 * @description 用户实体，对应数据库表fast_user
 */
@Data
@AllArgsConstructor//这个注解会生成一个包含所有属性的构造函数
@NoArgsConstructor//这个注解会生成一个无参构造函数
//@Data注解是一个组合注解，它包含了@Getter、@Setter、@ToString、@EqualsAndHashCode和@RequiredArgsConstructor这五个注解
public class User {
    //用户id
    private Long userId;
    //用户名
    private String userName;
    //用户密码
    private String passWord;
    //用户头像存储路径
    private String avatar;
    //用户性别
    private Long sex;
    //用户创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //JsonFormat注解用于指定日期时间格式
    //pattern属性指定日期时间格式，这里指定为yyyy-MM-dd HH:mm:ss
    //这样，当将User对象转换成json格式时，日期时间字段会按照指定的格式进行格式化
    private Date createTime;
}
