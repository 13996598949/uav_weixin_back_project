package com.lp.uav_weixin_back_project.uav_order.model.dto;

public class ConfirmDto {

    private Integer userId;

    private Integer orderId;

    private String buyPassword;

    private Integer sellId;

    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

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
