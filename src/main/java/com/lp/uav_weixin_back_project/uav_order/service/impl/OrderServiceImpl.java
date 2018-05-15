package com.lp.uav_weixin_back_project.uav_order.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_order.model.dto.*;
import com.lp.uav_weixin_back_project.uav_order.model.vo.CountOrderVo;
import com.lp.uav_weixin_back_project.uav_order.model.vo.EvaluateInfoVo;
import com.lp.uav_weixin_back_project.uav_order.model.vo.MySellInfoVo;
import com.lp.uav_weixin_back_project.uav_order.model.vo.OrderInfoVo;
import com.lp.uav_weixin_back_project.uav_order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BaseDao baseDao;


    @Override
    public List<MySellInfoVo> getMySellRentInfo(Integer userId) {
        List<MySellInfoVo> mySellInfoVoList = baseDao.getList("com.lp.sqlMapper.order.OrderRent.getMySellRentInfo",userId);
        return mySellInfoVoList;
    }

    @Override
    public List<MySellInfoVo> getMySellSaleInfo(Integer userId) {
        List<MySellInfoVo> mySellInfoVoList = baseDao.getList("com.lp.sqlMapper.order.OrderSale.getMySellSaleInfo",userId);
        return mySellInfoVoList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteRentOrder(Integer orderId) {
        int count = baseDao.delete("com.lp.sqlMapper.order.OrderRent.deleteRentOrder",orderId);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteSaleOrder(Integer orderId) {
        int count = baseDao.delete("com.lp.sqlMapper.order.OrderSale.deleteSaleOrder",orderId);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfoVo insertSaleOrder(InsertOrderDto dto) throws MyError {
        // 随机生成订单编号
        String orderNum = getOrderId();
        Map<String,Object> map = new HashMap<>();
        map.put("sellId",dto.getSellId());
        map.put("buyId",dto.getBuyId());
        map.put("saleProductId",dto.getProductId());
        map.put("addressId",dto.getAddressId());
        map.put("orderNum",orderNum);
        map.put("price",dto.getPrice());
        map.put("createTime",new Date());
        map.put("lastUpdateTime",new Date());
        map.put("orderId",0);
        int count = baseDao.insert("com.lp.sqlMapper.order.OrderSale.insertSaleOrder",map);
        if (count<=0){
            throw new MyError("保存失败，系统错误！");
        }
        baseDao.update("com.lp.sqlMapper.sale.SaleProduct.updateSaleProductFlag",map);

        int orderId = (int) map.get("orderId");
        OrderInfoVo orderInfoVo = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderSale.getSaleOrderInfo",orderId);
        if (orderInfoVo!=null){
            orderInfoVo.setAddress(orderInfoVo.getProvince() + " " + orderInfoVo.getCity() + " " + orderInfoVo.getCounty() + " " + orderInfoVo.getDistrict_detail());
            if (orderInfoVo.getBuyTime()!=null && !orderInfoVo.getBuyTime().equals("")) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                orderInfoVo.setBuyTimeStr(format.format(orderInfoVo.getBuyTime()));
            }
        }
        return orderInfoVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfoVo insertRentOrder(InsertOrderDto dto) throws MyError {
        // 随机生成订单编号
        String orderNum = getOrderId();
        Map<String,Object> map = new HashMap<>();
        map.put("sellId",dto.getSellId());
        map.put("buyId",dto.getBuyId());
        map.put("rentProductId",dto.getProductId());
        map.put("addressId",dto.getAddressId());
        map.put("rentDay",dto.getRentDay());
        map.put("price",dto.getPrice());
        map.put("orderNum",orderNum);
        map.put("createTime",new Date());
        map.put("lastUpdateTime",new Date());
        map.put("orderId",0);
        int count = baseDao.insert("com.lp.sqlMapper.order.OrderRent.insertRentOrder",map);
        if (count<=0){
            throw new MyError("保存失败，系统错误！");
        }
        baseDao.update("com.lp.sqlMapper.rent.RentProduct.updateRentProductFlag",map);

        int orderId = (int) map.get("orderId");
        OrderInfoVo orderInfoVo = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderRent.getRentOrderInfo",orderId);
        if (orderInfoVo!=null){
            orderInfoVo.setAddress(orderInfoVo.getProvince() + " " + orderInfoVo.getCity() + " " + orderInfoVo.getCounty() + " " + orderInfoVo.getDistrict_detail());
            if (orderInfoVo.getBuyTime()!=null && !orderInfoVo.getBuyTime().equals("")) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                orderInfoVo.setBuyTimeStr(format.format(orderInfoVo.getBuyTime()));
            }
        }

        return orderInfoVo;
    }

    @Override
    public List<MySellInfoVo> getMyBuyRentInfo(Integer userId) {
        List<MySellInfoVo> mySellInfoVoList = baseDao.getList("com.lp.sqlMapper.order.OrderRent.getMyBuyRentInfo",userId);
        return mySellInfoVoList;
    }

    @Override
    public List<MySellInfoVo> getMyBuySaleInfo(Integer userId) {
        List<MySellInfoVo> mySellInfoVoList = baseDao.getList("com.lp.sqlMapper.order.OrderSale.getMyBuySaleInfo",userId);
        return mySellInfoVoList;
    }

    @Override
    public OrderInfoVo getRentOrderInfo(Integer orderId) {
        OrderInfoVo orderInfoVo = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderRent.getRentOrderInfo",orderId);
        if (orderInfoVo!=null){
            orderInfoVo.setAddress(orderInfoVo.getProvince() + " " + orderInfoVo.getCity() + " " + orderInfoVo.getCounty() + " " + orderInfoVo.getDistrict_detail());
            if (orderInfoVo.getBuyTime()!=null && !orderInfoVo.getBuyTime().equals("")) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                orderInfoVo.setBuyTimeStr(format.format(orderInfoVo.getBuyTime()));
            }
        }
        return orderInfoVo;
    }

    @Override
    public OrderInfoVo getSaleOrderInfo(Integer orderId) {
        OrderInfoVo orderInfoVo = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderSale.getSaleOrderInfo",orderId);
        if (orderInfoVo!=null){
            orderInfoVo.setAddress(orderInfoVo.getProvince() + " " + orderInfoVo.getCity() + " " + orderInfoVo.getCounty() + " " + orderInfoVo.getDistrict_detail());
            if (orderInfoVo.getBuyTime()!=null && !orderInfoVo.getBuyTime().equals("")) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                orderInfoVo.setBuyTimeStr(format.format(orderInfoVo.getBuyTime()));
            }
        }
        return orderInfoVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int closeRentOrder(Integer orderId, Integer productId) {
        int count = baseDao.delete("com.lp.sqlMapper.order.OrderRent.deleteRentOrder",orderId);
        baseDao.update("com.lp.sqlMapper.order.OrderRent.updateProductFlag",productId);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int closeSaleOrder(Integer orderId, Integer productId) {
        int count = baseDao.delete("com.lp.sqlMapper.order.OrderSale.deleteSaleOrder",orderId);
        baseDao.update("com.lp.sqlMapper.order.OrderSale.updateProductFlag",productId);
        return count;
    }

    @Override
    public OrderInfoVo toPayRentOrder(PayDto payDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",payDto.getUserId());
        String buyPassword = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getBuyPassword",map);
        if (buyPassword.equals(payDto.getBuyPassword())) {
            map.put("orderId",payDto.getOrderId());
            int count = baseDao.update("com.lp.sqlMapper.order.OrderRent.toPayRent",map);
            OrderInfoVo orderInfoVo = this.getRentOrderInfo(payDto.getOrderId());
            return orderInfoVo;

        }else {
            throw new MyError("交易密码输入错误，请重新输入！");
        }
    }

    @Override
    public OrderInfoVo toPaySaleOrder(PayDto payDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",payDto.getUserId());
        String buyPassword = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getBuyPassword",map);
        if (buyPassword.equals(payDto.getBuyPassword())) {
            map.put("orderId",payDto.getOrderId());
            int count = baseDao.update("com.lp.sqlMapper.order.OrderSale.toPaySale",map);
            OrderInfoVo orderInfoVo = this.getSaleOrderInfo(payDto.getOrderId());
            return orderInfoVo;

        }else {
            throw new MyError("交易密码输入错误，请重新输入！");
        }
    }

    @Override
    public int toRefundRentOrder(ToRefundDto refundDto) {
        int count = baseDao.update("com.lp.sqlMapper.order.OrderRent.toRefundRentOrder", refundDto);
        return count;
    }

    @Override
    public int toRefundSaleOrder(ToRefundDto refundDto) {
        int count = baseDao.update("com.lp.sqlMapper.order.OrderSale.toRefundSaleOrder", refundDto);
        return count;
    }

    @Override
    public int toRentDelicery(ToDeliveryDto deliveryDto) {
        int count = baseDao.update("com.lp.sqlMapper.order.OrderRent.toRentDelicery",deliveryDto);
        return count;
    }

    @Override
    public int toSaleDelicery(ToDeliveryDto deliveryDto) {
        int count = baseDao.update("com.lp.sqlMapper.order.OrderSale.toSaleDelicery",deliveryDto);
        return count;
    }

    @Override
    public OrderInfoVo toConfirmRentOrder(ConfirmDto confirmDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",confirmDto.getUserId());
        String buyPassword = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getBuyPassword",map);
        if (buyPassword.equals(confirmDto.getBuyPassword())) {
            map.put("orderId",confirmDto.getOrderId());
            int count = baseDao.update("com.lp.sqlMapper.order.OrderRent.toConfirmRentOrder",map);
            OrderInfoVo orderInfoVo = this.getRentOrderInfo(confirmDto.getOrderId());
            return orderInfoVo;

        }else {
            throw new MyError("交易密码输入错误，请重新输入！");
        }
    }

    @Override
    public OrderInfoVo toConfirmSaleOrder(ConfirmDto confirmDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",confirmDto.getUserId());
        String buyPassword = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getBuyPassword",map);
        if (buyPassword.equals(confirmDto.getBuyPassword())) {
            map.put("orderId",confirmDto.getOrderId());
            int count = baseDao.update("com.lp.sqlMapper.order.OrderSale.toConfirmSaleOrder",map);
            OrderInfoVo orderInfoVo = this.getSaleOrderInfo(confirmDto.getOrderId());
            return orderInfoVo;

        }else {
            throw new MyError("交易密码输入错误，请重新输入！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfoVo toEvaluateRentOrder(EvaluateDto evaluateDto) {
        Map<String,Object> map = new HashMap<>();
        map.put("orderId",evaluateDto.getOrderId());
        map.put("tallPersonId",evaluateDto.getTallPersonId());
        map.put("talledPersonId",evaluateDto.getTalledPersonId());
        map.put("evaluate",evaluateDto.getEvaluate());
        map.put("goodFlag",evaluateDto.getGoodFlag());
        map.put("createTime",new Date());
        baseDao.insert("com.lp.sqlMapper.order.OrderRent.toEvaluateRentOrder",map);
        if (evaluateDto.getFlag().equals("buy")){
            map.put("buy_evaluate_flag",1);
            baseDao.update("com.lp.sqlMapper.order.OrderRent.updateRentActiveForEvaluate", map);
        }else if (evaluateDto.getFlag().equals("sale")){
            map.put("sale_evaluate_flag",1);
            baseDao.update("com.lp.sqlMapper.order.OrderRent.updateRentActiveForEvaluate", map);
        }
        OrderInfoVo orderInfoVo = this.getRentOrderInfo(evaluateDto.getOrderId());
        return orderInfoVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfoVo toEvaluateSaleOrder(EvaluateDto evaluateDto) {
        Map<String,Object> map = new HashMap<>();
        map.put("orderId",evaluateDto.getOrderId());
        map.put("tallPersonId",evaluateDto.getTallPersonId());
        map.put("talledPersonId",evaluateDto.getTalledPersonId());
        map.put("evaluate",evaluateDto.getEvaluate());
        map.put("goodFlag",evaluateDto.getGoodFlag());
        map.put("createTime",new Date());
        baseDao.insert("com.lp.sqlMapper.order.OrderSale.toEvaluateSaleOrder",map);
        if (evaluateDto.getFlag().equals("buy")){
            map.put("buy_evaluate_flag",1);
            baseDao.update("com.lp.sqlMapper.order.OrderSale.updateSaleActiveForEvaluate", map);
        }else if (evaluateDto.getFlag().equals("sale")){
            map.put("sale_evaluate_flag",1);
            baseDao.update("com.lp.sqlMapper.order.OrderSale.updateSaleActiveForEvaluate", map);
        }
        OrderInfoVo orderInfoVo = this.getRentOrderInfo(evaluateDto.getOrderId());
        return orderInfoVo;
    }

    @Override
    public List<EvaluateInfoVo> getEvaluateRentInfo(Integer orderId) {
        List<EvaluateInfoVo> evaluateInfoVos = baseDao.getList("com.lp.sqlMapper.order.OrderRent.getEvaluateRentInfo",orderId);
        if (evaluateInfoVos!=null && evaluateInfoVos.size()>0){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (EvaluateInfoVo vo :evaluateInfoVos){
                if (vo.getTallTime()!=null && !vo.getTallTime().equals("")){
                    vo.setTallTimeStr(format.format(vo.getTallTime()));
                }
            }
        }
        return evaluateInfoVos;
    }

    @Override
    public List<EvaluateInfoVo> getEvaluateSaleInfo(Integer orderId) {
        List<EvaluateInfoVo> evaluateInfoVos = baseDao.getList("com.lp.sqlMapper.order.OrderSale.getEvaluateSaleInfo",orderId);
        if (evaluateInfoVos!=null && evaluateInfoVos.size()>0){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (EvaluateInfoVo vo :evaluateInfoVos){
                if (vo.getTallTime()!=null && !vo.getTallTime().equals("")){
                    vo.setTallTimeStr(format.format(vo.getTallTime()));
                }
            }
        }
        return evaluateInfoVos;
    }

    @Override
    public CountOrderVo countOrderNum(Integer userId) {
        CountOrderVo countOrderVo = new CountOrderVo();
        // 统计待付款的订单
        int payNumRent = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderRent.countPayRent",userId);
        int payNumSale = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderSale.countPaySale",userId);
        countOrderVo.setPayNum(payNumRent+payNumSale);

        // 统计待发货的订单
        int deliveryNumRent = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderRent.countDeliveryRent",userId);
        int deliveryNumSale = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderSale.countDeliverySale",userId);
        countOrderVo.setDeliveryNum(deliveryNumRent+deliveryNumSale);

        // 统计待收货的订单
        int reviceNumRent = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderRent.countReviceRent",userId);
        int reviceNumSale = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderSale.countReviceSale",userId);
        countOrderVo.setReciveNum(reviceNumRent+reviceNumSale);

        // 统计待评价的订单
        int confirmNumRent = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderRent.countConfirmRent",userId);
        int confirmNumSale = baseDao.getOneBySqlId("com.lp.sqlMapper.order.OrderSale.countConfirmSale",userId);
        countOrderVo.setConfirmNum(confirmNumRent+confirmNumSale);

        return countOrderVo;
    }

    @Override
    public List<MySellInfoVo> getPayingRentList(Integer userId) {
        List<MySellInfoVo> payingRentList = baseDao.getList("com.lp.sqlMapper.order.OrderRent.getPayingRentList",userId);
        return payingRentList;
    }

    @Override
    public List<MySellInfoVo> getPayingSaleList(Integer userId) {
        List<MySellInfoVo> payingSaleList = baseDao.getList("com.lp.sqlMapper.order.OrderSale.getPayingSaleList",userId);
        return payingSaleList;
    }

    @Override
    public List<MySellInfoVo> getDeliveryRentList(Integer userId) {
        List<MySellInfoVo> deliveryRentList = baseDao.getList("com.lp.sqlMapper.order.OrderRent.getDeliveryRentList",userId);
        return deliveryRentList;
    }

    @Override
    public List<MySellInfoVo> getDeliverySaleList(Integer userId) {
        List<MySellInfoVo> deliverySaleList = baseDao.getList("com.lp.sqlMapper.order.OrderSale.getDeliverySaleList",userId);
        return deliverySaleList;
    }

    @Override
    public List<MySellInfoVo> getConfirmRentList(Integer userId) {
        List<MySellInfoVo> confirmRentList = baseDao.getList("com.lp.sqlMapper.order.OrderRent.getConfirmRentList",userId);
        return confirmRentList;
    }

    @Override
    public List<MySellInfoVo> getConfirmSaleList(Integer userId) {
        List<MySellInfoVo> confirmSaleList = baseDao.getList("com.lp.sqlMapper.order.OrderSale.getConfirmSaleList",userId);
        return confirmSaleList;
    }

    @Override
    public List<MySellInfoVo> getEvaluateRentList(Integer userId) {
        List<MySellInfoVo> evaluateRentList = baseDao.getList("com.lp.sqlMapper.order.OrderRent.getEvaluateRentList",userId);
        return evaluateRentList;
    }

    @Override
    public List<MySellInfoVo> getEvaluateSaleList(Integer userId) {
        List<MySellInfoVo> evaluateSaleList = baseDao.getList("com.lp.sqlMapper.order.OrderSale.getEvaluateSaleList",userId);
        return evaluateSaleList;
    }


    private String getOrderId(){
        // 随机生成订单号 当前时间+五位随机数
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = simpleDateFormat.format(new Date());
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        return str+rannum;
    }
}
