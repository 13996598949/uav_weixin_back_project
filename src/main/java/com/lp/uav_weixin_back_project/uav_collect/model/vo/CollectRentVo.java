package com.lp.uav_weixin_back_project.uav_collect.model.vo;

public class CollectRentVo {
    private Integer id;

    private String rentProductName;

    private String rentProductDescribe;

    private Double rentProductPrice;

    private String rentProductPicture;

    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
