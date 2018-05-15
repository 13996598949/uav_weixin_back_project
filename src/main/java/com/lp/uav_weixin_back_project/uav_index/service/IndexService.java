package com.lp.uav_weixin_back_project.uav_index.service;

import com.lp.uav_weixin_back_project.uav_index.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.SaleProductVo;

import java.util.List;

public interface IndexService {

    List<RentProductVo> getRentInfo(Integer userId);

    List<SaleProductVo> getSaleInfo(Integer userId);

    List<RentProductVo> getRecommendRent(Integer userId);

    List<SaleProductVo> getRecommendSale(Integer userId);

    List<RentProductVo> getNewRent(Integer userId);

    List<SaleProductVo> getNewSale(Integer userId);

    List<RentProductVo> getConsumerRent(Integer userId);

    List<SaleProductVo> getConsumerSale(Integer userId);

    List<RentProductVo> getProfessionalRent(Integer userId);

    List<SaleProductVo> getProfessionalSale(Integer userId);
}
