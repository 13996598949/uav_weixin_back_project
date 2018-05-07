package com.lp.uav_weixin_back_project.user.model.dto;

import com.lp.uav_weixin_back_project.model.Model;

public class EditPasswordDto extends Model {

    private String oldPassword;

    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}