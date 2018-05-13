package com.lp.uav_weixin_back_project.uav_order.model.dto;

public class EvaluateDto {

    private Integer orderId;

    private Integer tallPersonId;

    private Integer talledPersonId;

    private String evaluate;

    private Integer goodFlag;

    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTallPersonId() {
        return tallPersonId;
    }

    public void setTallPersonId(Integer tallPersonId) {
        this.tallPersonId = tallPersonId;
    }

    public Integer getTalledPersonId() {
        return talledPersonId;
    }

    public void setTalledPersonId(Integer talledPersonId) {
        this.talledPersonId = talledPersonId;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public Integer getGoodFlag() {
        return goodFlag;
    }

    public void setGoodFlag(Integer goodFlag) {
        this.goodFlag = goodFlag;
    }
}
