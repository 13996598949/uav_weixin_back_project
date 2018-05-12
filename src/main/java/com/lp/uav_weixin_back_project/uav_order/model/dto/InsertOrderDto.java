package com.lp.uav_weixin_back_project.uav_order.model.dto;

public class InsertOrderDto {

    private Integer sellId;

    private Integer buyId;

    private Integer productId;

    private Integer rentDay;

    private Integer addressId;

    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRentDay() {
        return rentDay;
    }

    public void setRentDay(Integer rentDay) {
        this.rentDay = rentDay;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
