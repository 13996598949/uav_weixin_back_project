package com.lp.uav_weixin_back_project.uav_order.service;

import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_order.model.dto.*;
import com.lp.uav_weixin_back_project.uav_order.model.vo.*;
import com.lp.uav_weixin_back_project.user.model.vo.UserVo;

import java.util.List;

public interface OrderService {

    List<MySellInfoVo> getMySellRentInfo(Integer userId);

    List<MySellInfoVo> getMySellSaleInfo(Integer userId);

    int deleteRentOrder(Integer orderId, String flag);

    int deleteSaleOrder(Integer orderId, String flag);

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

    UserVo toRefundRentOrder(ToRefundDto refundDto);

    UserVo toRefundSaleOrder(ToRefundDto refundDto);

    int toRentDelicery(ToDeliveryDto deliveryDto);

    int toSaleDelicery(ToDeliveryDto deliveryDto);

    OrderInfoVo toConfirmRentOrder(ConfirmDto confirmDto) throws MyError;

    OrderInfoVo toConfirmSaleOrder(ConfirmDto confirmDto) throws MyError;

    OrderInfoVo toEvaluateRentOrder(EvaluateDto evaluateDto);

    OrderInfoVo toEvaluateSaleOrder(EvaluateDto evaluateDto);

    List<EvaluateInfoVo> getEvaluateRentInfo(Integer orderId);

    List<EvaluateInfoVo> getEvaluateSaleInfo(Integer orderId);

    CountOrderVo countOrderNum(Integer userId);

    List<MySellInfoVo> getPayingRentList(Integer userId);

    List<MySellInfoVo> getPayingSaleList(Integer userId);

    List<MySellInfoVo> getDeliveryRentList(Integer userId);

    List<MySellInfoVo> getDeliverySaleList(Integer userId);

    List<MySellInfoVo> getConfirmRentList(Integer userId);

    List<MySellInfoVo> getConfirmSaleList(Integer userId);

    List<MySellInfoVo> getEvaluateRentList(Integer userId);

    List<MySellInfoVo> getEvaluateSaleList(Integer userId);

    int toRefundDeposit(RefundDepositDto depositDto);

    RefundDepositVo getRefundDepositInfo(Integer orderId);

    UserVo sellRefundDeposit(DepositDto depositDto) throws MyError;
}
