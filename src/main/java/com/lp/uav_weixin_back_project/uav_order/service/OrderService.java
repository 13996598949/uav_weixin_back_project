package com.lp.uav_weixin_back_project.uav_order.service;

import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_order.model.dto.InsertOrderDto;
import com.lp.uav_weixin_back_project.uav_order.model.vo.MySellInfoVo;

import java.util.List;

public interface OrderService {

    List<MySellInfoVo> getMySellRentInfo(Integer userId);

    List<MySellInfoVo> getMySellSaleInfo(Integer userId);

    int deleteRentOrder(Integer orderId);

    int deleteSaleOrder(Integer orderId);

    int insertSaleOrder(InsertOrderDto dto) throws MyError;

    int insertRentOrder(InsertOrderDto dto) throws MyError;
}
