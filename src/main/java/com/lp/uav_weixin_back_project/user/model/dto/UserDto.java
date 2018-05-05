package com.lp.uav_weixin_back_project.user.model.dto;

import com.lp.uav_weixin_back_project.model.Model;

import java.util.Date;

public class UserDto extends Model {

    private String personName;

    private String userName;

    private String loginPassword;

    private String buyPassword;

    private String mail;

    private String telephone;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getBuyPassword() {
        return buyPassword;
    }

    public void setBuyPassword(String buyPassword) {
        this.buyPassword = buyPassword;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}