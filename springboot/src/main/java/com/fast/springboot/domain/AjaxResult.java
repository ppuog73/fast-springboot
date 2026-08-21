package com.fast.springboot.domain;

import java.util.HashMap;

/**
 * @author i666
 * @date 2026/8/20 20:26
 * @description 操作消息提醒
 */
public class AjaxResult extends HashMap<String, Object> {
    /*
     * 初始化一个新建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult() {}

    /*
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type 消息类型
     * @param msg 返回内容
     */
    public AjaxResult(int code, String msg) {
        // 调用父类的put方法，将键值对添加到HashMap中，状态码
        super.put("code", code);
        // 调用父类的put方法，将键值对添加到HashMap中，消息内容
        super.put("msg", msg);
        //super用法：
        //super关键字用于在子类中调用父类的方法或访问父类的成员变量。
        //super可以用于以下几种情况：
        //调用父类的构造函数：在子类的构造函数中，可以使用super()来调用父类的默认构造函数。
        //调用父类的方法：在子类中，可以使用super.methodName()来调用父类中指定的方法。
        //访问父类的成员变量：在子类中，可以使用super.variableName来访问父类中指定的成员变量。
        //需要注意的是，super只能在子类中使用，不能在父类中使用。
        //此外，super还可以用于多态的情况下，调用父类的方法或访问父类的成员变量。
        //在这种情况下，super指向的是子类对象所引用的父类对象。
        //例如：
        //class Parent {
        //    void method() {
        //        System.out.println("Parent method");  // 父类方法
        //    }
        //}
        //
        //class Child extends Parent {
        //    void method() {
        //        super.method();  // 调用父类的method方法
        //        System.out.println("Child method");  // 子类方法
        //    }
        //}
    }
    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public AjaxResult(int code, String msg, Object data) {
        // 调用父类的put方法，将键值对添加到HashMap中，状态码
        super.put("code", code);
        // 调用父类的put方法，将键值对添加到HashMap中，消息内容
        super.put("msg", msg);
        // 调用父类的put方法，将键值对添加到HashMap中，数据对象
        if (data != null) {
            super.put("data", data);
        }
    }

    /**
     * 返回成功消息
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static AjaxResult success(String msg, Object data) {
        //这里为什么可以返回一个带有三个参数的对象？
        //因为success方法返回的是一个AjaxResult对象，而AjaxResult类是一个HashMap的子类，所以可以返回一个带有三个参数的对象。
        return new AjaxResult(200, msg, data);
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @param data 数据对象
     * @return 成功消息和数据
     */
    public static AjaxResult success(Object data) {
        return  AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功数据
     *
     * @param msg 数据对象
     * @return 成功消息和数据
     */
    public static AjaxResult success(String  msg) {
        return  AjaxResult.success(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @return 警告消息
     */
    public static AjaxResult error() {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     * @param msg 返回内容
     * @return 返回自定义错误消息
     */
    public static AjaxResult error(String msg) {
        return AjaxResult.error(msg,null);
    }

    /**
     * 返回错误消息
     * @param msg 返回内容
     * @param data 数据对象
     * @return 返回自定义错误消息和数据
     */
    public static AjaxResult error(String msg,Object data) {
        return new AjaxResult(500,msg,data);
    }

    /**
     * 返回错误消息
     * @param data 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(Object data) {
        return AjaxResult.error("操作失败", null);
    }

    /**
     * 返回错误消息
     * @param code 自定义错误码
     * @param msg 自定义错误消息
     * @return 返回自定义错误消息和数据
     */
    public static AjaxResult error(int code,String msg) {
        return new AjaxResult(500,msg,null);
    }

    /**
     * 方便链式调用
     * 子类重写了父类的put方法，这样就可以在子类中使用put方法了。
     * @param key 键
     * @param value 值
     * @return 数据对象
     */
    @Override
    public AjaxResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
