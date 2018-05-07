package com.lp.uav_weixin_back_project.user.model.dto;

import com.lp.uav_weixin_back_project.model.Model;

public class AddressDto extends Model {

    private String receiveName;

    private String telephone;

    private String province;

    private String city;

    private String county;

    private String districtDetail;

    private String postalCode;

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDistrictDetail() {
        return districtDetail;
    }

    public void setDistrictDetail(String districtDetail) {
        this.districtDetail = districtDetail;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}