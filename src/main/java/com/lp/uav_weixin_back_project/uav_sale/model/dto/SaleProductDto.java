package com.lp.uav_weixin_back_project.uav_sale.model.dto;

public class SaleProductDto {
    private String saleProductName;

    private String saleProductDescribe;

    private Double saleProductPrice;

    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
