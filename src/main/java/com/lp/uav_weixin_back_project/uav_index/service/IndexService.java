package com.lp.uav_weixin_back_project.uav_index.service;

import com.lp.uav_weixin_back_project.uav_index.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.SaleProductVo;

import java.util.List;

public interface IndexService {

    List<RentProductVo> getRentInfo(Integer userId);

    List<SaleProductVo> getSaleInfo(Integer userId);
}
