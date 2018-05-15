package com.lp.uav_weixin_back_project.uav_index.service;

import com.lp.uav_weixin_back_project.uav_index.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.SaleProductVo;

import java.util.List;

public interface IndexService {

    List<RentProductVo> getRentInfo(Integer userId);

    List<SaleProductVo> getSaleInfo(Integer userId);

    List<RentProductVo> getRecommendRent(Integer userId, String searchName);

    List<SaleProductVo> getRecommendSale(Integer userId, String searchName);

    List<RentProductVo> getNewRent(Integer userId, String searchName);

    List<SaleProductVo> getNewSale(Integer userId, String searchName);

    List<RentProductVo> getConsumerRent(Integer userId, String searchName);

    List<SaleProductVo> getConsumerSale(Integer userId, String searchName);

    List<RentProductVo> getProfessionalRent(Integer userId, String searchName);

    List<SaleProductVo> getProfessionalSale(Integer userId, String searchName);
}
