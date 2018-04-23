package com.lp.uav_weixin_back_project.model;


import java.io.Serializable;

/**
 * 响应实体
 * @param <T>
 */
public class ResultEntity<T> implements Serializable {

    /**
     * 响应请求状态
     * TRUE：成功，FALSE：失败
     */
    private boolean status = true;

    /**
     * 响应消息
     */
    private String message = "";
    /**
     * 响应数据
     */
    private T data;

    /**
     * 默认构造方法
     */
    public ResultEntity() {

    }

    /**
     * 构造方法
     *
     * @param message 响应消息
     */
    public ResultEntity(String message) {
        this.setMessage(message);
    }

    /**
     * 构造方法
     *
     * @param data 响应数据
     */
    public ResultEntity(T data) {
        this.setData(data);
    }

    /**
     * 构造方法
     *
     * @param data    响应数据
     * @param message 响应消息
     */
    public ResultEntity(T data, String message) {
        this.setData(data);
        this.setMessage(message);
    }

    /**
     * 构造方法
     *
     * @param message 响应消息
     * @param status  响应请求状态
     */
    public ResultEntity(String message, boolean status) {
        this.setStatus(status);
        this.setMessage(message);
    }

    /**
     * 构造方法
     *
     * @param data    响应数据
     * @param message 响应消息
     * @param status  响应请求状态
     */
    public ResultEntity(T data, String message, boolean status) {
        this.setStatus(status);
        this.setData(data);
        this.setMessage(message);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message != null) {
            this.message = message;
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
