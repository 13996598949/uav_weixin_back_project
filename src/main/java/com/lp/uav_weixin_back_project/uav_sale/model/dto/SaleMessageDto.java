package com.lp.uav_weixin_back_project.uav_sale.model.dto;

public class SaleMessageDto {

    private Integer productId;

    private Integer personId;

    private String message;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
