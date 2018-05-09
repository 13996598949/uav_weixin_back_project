package com.lp.uav_weixin_back_project.uav_collect.model.vo;

public class CollectSaleVo {
    private Integer id;

    private String saleProductName;

    private String saleProductDescribe;

    private Double saleProductPrice;

    private String saleProductPicture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
