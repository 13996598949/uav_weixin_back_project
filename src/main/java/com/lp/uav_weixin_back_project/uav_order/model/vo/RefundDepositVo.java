package com.lp.uav_weixin_back_project.uav_order.model.vo;

import java.util.Date;

public class RefundDepositVo {
    private Integer orderId;

    private String rent_product_name;

    private String rent_product_picture;

    private String postCompany;

    private String postNum;

    private String orderNum;

    private Date createTime;

    private String createTimeStr;

    private Integer active;

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getRent_product_name() {
        return rent_product_name;
    }

    public void setRent_product_name(String rent_product_name) {
        this.rent_product_name = rent_product_name;
    }

    public String getRent_product_picture() {
        return rent_product_picture;
    }

    public void setRent_product_picture(String rent_product_picture) {
        this.rent_product_picture = rent_product_picture;
    }

    public String getPostCompany() {
        return postCompany;
    }

    public void setPostCompany(String postCompany) {
        this.postCompany = postCompany;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}
