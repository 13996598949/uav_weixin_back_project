package com.lp.uav_weixin_back_project.uav_collect.service;

import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectRentVo;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectSaleVo;

import java.util.List;

public interface CollectService {

    int insertCollectRent(Integer userId, Integer productId) throws MyError;

    List<CollectRentVo> getCollectRent(Integer userId);

    Integer deleteCollectRent(Integer userId, Integer productId);

    int insertCollectSale(Integer userId, Integer productId) throws MyError;

    List<CollectSaleVo> getCollectSale(Integer userId);

    Integer deleteCollectSale(Integer userId, Integer productId);
}
