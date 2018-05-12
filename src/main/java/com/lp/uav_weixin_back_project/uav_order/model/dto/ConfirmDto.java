package com.lp.uav_weixin_back_project.uav_order.model.dto;

public class ConfirmDto {

    private Integer userId;

    private Integer orderId;

    private String buyPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getBuyPassword() {
        return buyPassword;
    }

    public void setBuyPassword(String buyPassword) {
        this.buyPassword = buyPassword;
    }
}
