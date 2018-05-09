package com.lp.uav_weixin_back_project.uav_rent.model.vo;

import com.lp.uav_weixin_back_project.model.Model;

public class RentProductVo extends Model {
    private Integer id;

    private Integer userId;

    private String rentProductName;

    private String rentProductDescribe;

    private Double rentProductPrice;

    private String rentProductPicture;

    private Integer credit;

    private boolean isCollectFlag = false;

    public boolean isCollectFlag() {
        return isCollectFlag;
    }

    public void setCollectFlag(boolean collectFlag) {
        isCollectFlag = collectFlag;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRentProductName() {
        return rentProductName;
    }

    public void setRentProductName(String rentProductName) {
        this.rentProductName = rentProductName;
    }

    public String getRentProductDescribe() {
        return rentProductDescribe;
    }

    public void setRentProductDescribe(String rentProductDescribe) {
        this.rentProductDescribe = rentProductDescribe;
    }

    public Double getRentProductPrice() {
        return rentProductPrice;
    }

    public void setRentProductPrice(Double rentProductPrice) {
        this.rentProductPrice = rentProductPrice;
    }

    public String getRentProductPicture() {
        return rentProductPicture;
    }

    public void setRentProductPicture(String rentProductPicture) {
        this.rentProductPicture = rentProductPicture;
    }
}