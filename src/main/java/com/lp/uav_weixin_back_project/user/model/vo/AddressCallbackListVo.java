package com.lp.uav_weixin_back_project.user.model.vo;

import com.lp.uav_weixin_back_project.model.Model;

public class AddressCallbackListVo extends Model {
    private Integer id;

    private String name;

    private String tel;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}