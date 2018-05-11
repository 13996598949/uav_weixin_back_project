package com.lp.uav_weixin_back_project.uav_sale.model.vo;

import com.lp.uav_weixin_back_project.model.Model;

import java.util.Date;

public class SaleProductDetailVo extends Model {
    private Integer id;

    private String header;

    private Integer userId;

    private String alias;

    private String saleProductName;

    private String saleProductDescribe;

    private Double saleProductPrice;

    private String saleProductPicture;

    private Integer credit;

    private Integer type;

    private Date createTime;

    private String createTimeStr;

    private Date lastUpdateTime;

    private String lastUpdateTimeStr;

    private boolean isCollectFlag = false;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isCollectFlag() {
        return isCollectFlag;
    }

    public void setCollectFlag(boolean collectFlag) {
        isCollectFlag = collectFlag;
    }

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