package com.lp.uav_weixin_back_project.uav_order.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectRentVo;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectSaleVo;
import com.lp.uav_weixin_back_project.uav_order.model.dto.InsertOrderDto;
import com.lp.uav_weixin_back_project.uav_order.model.vo.MySellInfoVo;
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
    public int deleteRentOrder(Integer orderId) {
        int count = baseDao.delete("com.lp.sqlMapper.order.OrderRent.deleteRentOrder",orderId);
        return count;
    }

    @Override
    public int deleteSaleOrder(Integer orderId) {
        int count = baseDao.delete("com.lp.sqlMapper.order.OrderSale.deleteSaleOrder",orderId);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSaleOrder(InsertOrderDto dto) throws MyError {
        // 随机生成订单编号
        String orderId = getOrderId();
        Map<String,Object> map = new HashMap<>();
        map.put("sellId",dto.getSellId());
        map.put("buyId",dto.getBuyId());
        map.put("saleProductId",dto.getProductId());
        map.put("addressId",dto.getAddressId());
        map.put("orderId",orderId);
        map.put("createTime",new Date());
        map.put("lastUpdateTime",new Date());
        int count = baseDao.insert("com.lp.sqlMapper.order.OrderSale.insertSaleOrder",map);
        baseDao.update("com.lp.sqlMapper.sale.SaleProduct.updateSaleProductFlag",map);
        if (count<=0){
            throw new MyError("保存失败，系统错误！");
        }
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertRentOrder(InsertOrderDto dto) throws MyError {
        // 随机生成订单编号
        String orderId = getOrderId();
        Map<String,Object> map = new HashMap<>();
        map.put("sellId",dto.getSellId());
        map.put("buyId",dto.getBuyId());
        map.put("rentProductId",dto.getProductId());
        map.put("addressId",dto.getAddressId());
        map.put("rentDay",dto.getRentDay());
        map.put("orderId",orderId);
        map.put("createTime",new Date());
        map.put("lastUpdateTime",new Date());
        int count = baseDao.insert("com.lp.sqlMapper.order.OrderRent.insertRentOrder",map);
        baseDao.update("com.lp.sqlMapper.rent.RentProduct.updateRentProductFlag",map);
        if (count<=0){
            throw new MyError("保存失败，系统错误！");
        }
        return count;
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
