package com.lp.uav_weixin_back_project.uav_order.model.vo;

import com.lp.uav_weixin_back_project.user.model.vo.UserVo;

import java.util.Date;

public class OrderInfoVo {

    private Integer productId;

    private Integer orderId;

    private Integer sellId;

    private Integer buyId;

    private Double price;

    private String productName;

    private String buyAlias;

    private String orderNum;

    private String buyTimeStr;

    private Date buyTime;

    private String picture;

    private Integer active;

    private String receiveName;

    private String telephone;

    private String province;

    private String city;

    private String county;

    private String district_detail;

    private String address;

    private String refundRes;

    private String postCompany;

    private String postNum;

    private Integer buy_evaluate_flag;

    private Integer sale_evaluate_flag;

    private Double deposit;

    private UserVo userVo;

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Integer getBuy_evaluate_flag() {
        return buy_evaluate_flag;
    }

    public void setBuy_evaluate_flag(Integer buy_evaluate_flag) {
        this.buy_evaluate_flag = buy_evaluate_flag;
    }

    public Integer getSale_evaluate_flag() {
        return sale_evaluate_flag;
    }

    public void setSale_evaluate_flag(Integer sale_evaluate_flag) {
        this.sale_evaluate_flag = sale_evaluate_flag;
    }

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public String getRefundRes() {
        return refundRes;
    }

    public void setRefundRes(String refundRes) {
        this.refundRes = refundRes;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBuyAlias() {
        return buyAlias;
    }

    public void setBuyAlias(String buyAlias) {
        this.buyAlias = buyAlias;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getBuyTimeStr() {
        return buyTimeStr;
    }

    public void setBuyTimeStr(String buyTimeStr) {
        this.buyTimeStr = buyTimeStr;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDistrict_detail() {
        return district_detail;
    }

    public void setDistrict_detail(String district_detail) {
        this.district_detail = district_detail;
    }
}
