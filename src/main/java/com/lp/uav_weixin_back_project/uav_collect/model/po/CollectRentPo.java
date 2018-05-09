package com.lp.uav_weixin_back_project.uav_collect.model.po;

import com.lp.uav_weixin_back_project.model.Model;
import java.util.Date;

public class CollectRentPo extends Model {
    private Integer id;

    private Integer userId;

    private Integer rentProductId;

    private Date createTime;

    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRentProductId() {
        return rentProductId;
    }

    public void setRentProductId(Integer rentProductId) {
        this.rentProductId = rentProductId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}