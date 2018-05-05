package com.lp.uav_weixin_back_project.exception;

public class MyError extends Exception{
    private String message;

    public MyError(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
