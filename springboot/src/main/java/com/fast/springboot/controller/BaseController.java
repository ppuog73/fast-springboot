package com.fast.springboot.controller;

import com.fast.springboot.domain.AjaxResult;

/**
 * @author i666
 * @date 2026/8/22 07:44
 * @description 通用基础控制器，用来做web层通用数据处理，所有控制器的爸爸
 * 所有的web层都继承这个控制器，这样就可以在这个控制器中处理一些通用的数据
 * 比如：类型转换、返回成功、失败、警告消息、获取用户缓存消息、获取全局通用数据等
 */
// 这个控制基类，不需要加注解，因为它不是一个控制器，而是一个基类，用来继承其他控制器
public class BaseController {
    /**
     * 返回带默认成功信息但是无数据的消息
     * @return AjaxResult
     */
    public AjaxResult success(){
        return AjaxResult.success();
    }

    /**
     * 返回带自定义成功信息但是无数据的成功消息
     * @return AjaxResult
     */
    public AjaxResult success(String msg){
        return AjaxResult.success(msg);
    }

    /**
     * 返回带自定义成功信息和数据的成功消息
     * @return AjaxResult
     */
    public AjaxResult success(String msg,Object data){
        return AjaxResult.success(msg,data);
    }

    /**
     * 返回带默认成功信息和数据的成功消息
     * @return AjaxResult
     */
    public AjaxResult success(Object data){
        return AjaxResult.success(data);
    }

    /**
     * 返回默认失败信息但是无数据的消息
     * @return AjaxResult
     */
    public AjaxResult error(){
        return AjaxResult.error();
    }

    /**
     * 返回带自定义失败信息但是无数据的错误消息
     * @return AjaxResult
     */
    public AjaxResult error(String msg){
        return AjaxResult.error(msg);
    }

    /**
     * 返回带自定义失败信息和数据的错误消息
     * @return AjaxResult
     */
    public AjaxResult error(String msg,Object data){
        return AjaxResult.error(msg,data);
    }

    /**
     * 返回带默认失败信息和数据的错误消息
     * @return AjaxResult
     */
    public AjaxResult error(Object data){
        return AjaxResult.error(data);
    }

    /**
     * 根据受影响的行数来判断是否操作成功
     * 受影响的行数大于0，操作成功，返回成功消息
     * 受影响的行数小于等于0，操作失败，返回失败消息
     * @param rows 影响行数
     * @return 操作结果
     */
    public AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 根据结果来判断是否操作成功
     * 结果为true，操作成功，返回成功消息
     * 结果为false，操作失败，返回失败消息
     * 结果为null，操作失败，返回失败消息
     * @param result 结果
     * @return 操作结果
     */
    public AjaxResult toAjax(boolean result)
    {
        return result ? success() : error();
    }
}
