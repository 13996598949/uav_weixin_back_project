package com.lp.uav_weixin_back_project.uav_order.model.dto;

public class ToRefundDto {
    private Integer orderId;

    private String refundRes;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getRefundRes() {
        return refundRes;
    }

    public void setRefundRes(String refundRes) {
        this.refundRes = refundRes;
    }
}
