package com.lp.uav_weixin_back_project.uav_index.model.vo;

import com.lp.uav_weixin_back_project.model.Model;

import java.util.Date;

public class SaleProductVo extends Model {
    private Integer id;

    private Integer userId;

    private String saleProductName;

    private String saleProductDescribe;

    private Double saleProductPrice;

    private String saleProductPicture;

    private Integer credit;

    private Integer type;

    private Integer viewNum;

    private Date createTime;

    private float socre;

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

    public float getSocre() {
        return socre;
    }

    public void setSocre(float socre) {
        this.socre = socre;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public String getSaleProductName() {
        return saleProductName;
    }

    public void setSaleProductName(String saleProductName) {
        this.saleProductName = saleProductName;
    }

    public String getSaleProductDescribe() {
        return saleProductDescribe;
    }

    public void setSaleProductDescribe(String saleProductDescribe) {
        this.saleProductDescribe = saleProductDescribe;
    }

    public Double getSaleProductPrice() {
        return saleProductPrice;
    }

    public void setSaleProductPrice(Double saleProductPrice) {
        this.saleProductPrice = saleProductPrice;
    }

    public String getSaleProductPicture() {
        return saleProductPicture;
    }

    public void setSaleProductPicture(String saleProductPicture) {
        this.saleProductPicture = saleProductPicture;
    }
}