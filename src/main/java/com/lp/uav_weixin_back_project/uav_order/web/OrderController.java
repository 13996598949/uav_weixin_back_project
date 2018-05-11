package com.lp.uav_weixin_back_project.uav_order.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_order.model.dto.InsertOrderDto;
import com.lp.uav_weixin_back_project.uav_order.model.vo.MySellInfoVo;
import com.lp.uav_weixin_back_project.uav_order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("getMySellRentInfo/{userId}")
    public ResultEntity<List<MySellInfoVo>> getMySellRentInfo(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> mySellInfoVos = orderService.getMySellRentInfo(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(mySellInfoVos);
        return resultEntity;
    }

    @GetMapping("getMySellSaleInfo/{userId}")
    public ResultEntity<List<MySellInfoVo>> getMySellSaleInfo(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> mySellInfoVos = orderService.getMySellSaleInfo(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(mySellInfoVos);
        return resultEntity;
    }

    @DeleteMapping("deleteRentOrder/{orderId}")
    public ResultEntity<Integer> deleteRentOrder(@PathVariable Integer orderId) throws Exception {
        int count = orderService.deleteRentOrder(orderId);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @DeleteMapping("deleteSaleOrder/{orderId}")
    public ResultEntity<Integer> deleteSaleOrder(@PathVariable Integer orderId) throws Exception {
        int count = orderService.deleteSaleOrder(orderId);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PostMapping("insertSaleOrder")
    public ResultEntity<Integer> insertSaleOrder(@RequestBody InsertOrderDto dto) throws Exception {
        int count = orderService.insertSaleOrder(dto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PostMapping("insertRentOrder")
    public ResultEntity<Integer> insertRentOrder(@RequestBody InsertOrderDto dto) throws Exception {
        int count = orderService.insertRentOrder(dto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @GetMapping("getMyBuyRentInfo/{userId}")
    public ResultEntity<List<MySellInfoVo>> getMyBuyRentInfo(@PathVariable Integer userId) throws Exception {
//        List<MySellInfoVo> mySellInfoVos = orderService.getMyBuyRentInfo(userId);
//        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(mySellInfoVos);
//        return resultEntity;
        return null;
    }

    @GetMapping("getMyBuySaleInfo/{userId}")
    public ResultEntity<List<MySellInfoVo>> getMyBuySaleInfo(@PathVariable Integer userId) throws Exception {
//        List<MySellInfoVo> mySellInfoVos = orderService.getMyBuySaleInfo(userId);
//        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(mySellInfoVos);
//        return resultEntity;
        return null;
    }
}
