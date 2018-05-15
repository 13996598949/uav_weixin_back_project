package com.lp.uav_weixin_back_project.uav_index.model.vo;

import com.lp.uav_weixin_back_project.model.Model;

import java.util.Date;

public class RentProductVo extends Model {
    private Integer id;

    private Integer userId;

    private String rentProductName;

    private String rentProductDescribe;

    private Double rentProductPrice;

    private String rentProductPicture;

    private Integer credit;

    private Integer type;

    private Integer viewNum;

    private Date createTime;

    private boolean isCollectFlag = false;

    private float socre;

    public float getSocre() {
        return socre;
    }

    public void setSocre(float socre) {
        this.socre = socre;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


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