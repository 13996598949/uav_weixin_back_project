package com.lp.uav_weixin_back_project.uav_order.model.vo;

import java.util.Date;

public class EvaluateInfoVo {

    private String tallPersonPicture;

    private String tallPersonAlias;

    private String tallPersonEvaluate;

    private Date tallTime;

    private String tallTimeStr;

    private Integer goodFlag;

    public String getTallPersonPicture() {
        return tallPersonPicture;
    }

    public void setTallPersonPicture(String tallPersonPicture) {
        this.tallPersonPicture = tallPersonPicture;
    }

    public String getTallPersonAlias() {
        return tallPersonAlias;
    }

    public void setTallPersonAlias(String tallPersonAlias) {
        this.tallPersonAlias = tallPersonAlias;
    }

    public String getTallPersonEvaluate() {
        return tallPersonEvaluate;
    }

    public void setTallPersonEvaluate(String tallPersonEvaluate) {
        this.tallPersonEvaluate = tallPersonEvaluate;
    }

    public Date getTallTime() {
        return tallTime;
    }

    public void setTallTime(Date tallTime) {
        this.tallTime = tallTime;
    }

    public String getTallTimeStr() {
        return tallTimeStr;
    }

    public void setTallTimeStr(String tallTimeStr) {
        this.tallTimeStr = tallTimeStr;
    }

    public Integer getGoodFlag() {
        return goodFlag;
    }

    public void setGoodFlag(Integer goodFlag) {
        this.goodFlag = goodFlag;
    }
}
