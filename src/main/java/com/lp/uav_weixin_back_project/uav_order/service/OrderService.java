package com.lp.uav_weixin_back_project.uav_order.service;

import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_order.model.dto.*;
import com.lp.uav_weixin_back_project.uav_order.model.vo.MySellInfoVo;
import com.lp.uav_weixin_back_project.uav_order.model.vo.OrderInfoVo;

import java.util.List;

public interface OrderService {

    List<MySellInfoVo> getMySellRentInfo(Integer userId);

    List<MySellInfoVo> getMySellSaleInfo(Integer userId);

    int deleteRentOrder(Integer orderId);

    int deleteSaleOrder(Integer orderId);

    OrderInfoVo insertSaleOrder(InsertOrderDto dto) throws MyError;

    OrderInfoVo insertRentOrder(InsertOrderDto dto) throws MyError;

    List<MySellInfoVo> getMyBuyRentInfo(Integer userId);

    List<MySellInfoVo> getMyBuySaleInfo(Integer userId);

    OrderInfoVo getRentOrderInfo(Integer orderId);

    OrderInfoVo getSaleOrderInfo(Integer orderId);

    int closeRentOrder(Integer orderId, Integer productId);

    int closeSaleOrder(Integer orderId, Integer productId);

    OrderInfoVo toPayRentOrder(PayDto payDto) throws MyError;

    OrderInfoVo toPaySaleOrder(PayDto payDto) throws MyError;

    int toRefundRentOrder(ToRefundDto refundDto);

    int toRefundSaleOrder(ToRefundDto refundDto);

    int toRentDelicery(ToDeliveryDto deliveryDto);

    int toSaleDelicery(ToDeliveryDto deliveryDto);

    OrderInfoVo toConfirmRentOrder(ConfirmDto confirmDto) throws MyError;

    OrderInfoVo toConfirmSaleOrder(ConfirmDto confirmDto) throws MyError;

    OrderInfoVo toEvaluateRentOrder(EvaluateDto evaluateDto);

    OrderInfoVo toEvaluateSaleOrder(EvaluateDto evaluateDto);
}
