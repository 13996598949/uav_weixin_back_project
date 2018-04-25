package com.lp.uav_weixin_back_project.uav_index.model.vo;

import com.lp.uav_weixin_back_project.model.Model;

public class SaleProductVo extends Model {
    private Integer id;

    private Integer userId;

    private String saleProductName;

    private String saleProductDescribe;

    private Double saleProductPrice;

    private String saleProductPicture;

    private Integer credit;

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