package com.lp.uav_weixin_back_project.exception;

import java.util.HashMap;
import java.util.Map;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandle {
    @ExceptionHandler(Exception.class)
    public ResultEntity<String> exception(Exception e) {
        ResultEntity<String> resultEntity = new ResultEntity();
        e.printStackTrace();
        resultEntity.setStatus(false);
        resultEntity.setMessage("系统错误！");
        return resultEntity;
    }
    @ExceptionHandler(MyError.class)
    public ResultEntity<String> myException(MyError e) {
        ResultEntity<String> resultEntity = new ResultEntity();
        resultEntity.setStatus(false);
        resultEntity.setMessage(e.getMessage());
        return resultEntity;
    }
}
