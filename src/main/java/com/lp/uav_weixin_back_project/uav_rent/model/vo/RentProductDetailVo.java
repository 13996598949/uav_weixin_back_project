package com.lp.uav_weixin_back_project.uav_rent.model.vo;

import com.lp.uav_weixin_back_project.model.Model;

import java.util.Date;

public class RentProductDetailVo extends Model {
    private Integer id;

    private String header;

    private String alias;

    private String rentProductName;

    private String rentProductDescribe;

    private Double rentProductPrice;

    private String rentProductPicture;

    private Integer credit;

    private Integer type;

    private Date createTime;

    private String createTimeStr;

    private Date lastUpdateTime;

    private String lastUpdateTimeStr;

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateTimeStr() {
        return lastUpdateTimeStr;
    }

    public void setLastUpdateTimeStr(String lastUpdateTimeStr) {
        this.lastUpdateTimeStr = lastUpdateTimeStr;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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