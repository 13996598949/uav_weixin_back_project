package com.lp.uav_weixin_back_project.uav_order.model.po;

import com.lp.uav_weixin_back_project.model.Model;

public class OrderRentPo extends Model {
    private Integer id;

    private Integer sellId;

    private Integer buyId;

    private Integer rentProductId;

    private Integer active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getRentProductId() {
        return rentProductId;
    }

    public void setRentProductId(Integer rentProductId) {
        this.rentProductId = rentProductId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}