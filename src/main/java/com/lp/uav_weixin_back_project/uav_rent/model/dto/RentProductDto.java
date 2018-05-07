package com.lp.uav_weixin_back_project.uav_rent.model.dto;

public class RentProductDto {
    private String rentProductName;

    private String rentProductDescribe;

    private Double rentProductPrice;

    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
