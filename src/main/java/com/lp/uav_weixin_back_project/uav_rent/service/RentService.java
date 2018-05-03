package com.lp.uav_weixin_back_project.uav_rent.service;

import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentProductVo;

import java.util.List;

public interface RentService {

    List<RentProductVo> getRentAllInfo();
}
