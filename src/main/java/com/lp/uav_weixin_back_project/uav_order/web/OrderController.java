package com.lp.uav_weixin_back_project.uav_order.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_order.model.dto.*;
import com.lp.uav_weixin_back_project.uav_order.model.vo.MySellInfoVo;
import com.lp.uav_weixin_back_project.uav_order.model.vo.OrderInfoVo;
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

    @DeleteMapping("closeRentOrder/{orderId}/{productId}")
    public ResultEntity<Integer> closeRentOrder(@PathVariable Integer orderId,@PathVariable Integer productId) throws Exception {
        int count = orderService.closeRentOrder(orderId,productId);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @DeleteMapping("closeSaleOrder/{orderId}/{productId}")
    public ResultEntity<Integer> closeSaleOrder(@PathVariable Integer orderId,@PathVariable Integer productId) throws Exception {
        int count = orderService.closeSaleOrder(orderId,productId);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PostMapping("insertSaleOrder")
    public ResultEntity<OrderInfoVo> insertSaleOrder(@RequestBody InsertOrderDto dto) throws Exception {
        OrderInfoVo orderInfoVo = orderService.insertSaleOrder(dto);
        ResultEntity<OrderInfoVo> resultEntity = new ResultEntity<>(orderInfoVo);
        return resultEntity;
    }

    @PostMapping("insertRentOrder")
    public ResultEntity<OrderInfoVo> insertRentOrder(@RequestBody InsertOrderDto dto) throws Exception {
        OrderInfoVo orderInfoVo = orderService.insertRentOrder(dto);
        ResultEntity<OrderInfoVo> resultEntity = new ResultEntity<>(orderInfoVo);
        return resultEntity;
    }

    @GetMapping("getMyBuyRentInfo/{userId}")
    public ResultEntity<List<MySellInfoVo>> getMyBuyRentInfo(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> mySellInfoVos = orderService.getMyBuyRentInfo(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(mySellInfoVos);
        return resultEntity;
    }

    @GetMapping("getMyBuySaleInfo/{userId}")
    public ResultEntity<List<MySellInfoVo>> getMyBuySaleInfo(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> mySellInfoVos = orderService.getMyBuySaleInfo(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(mySellInfoVos);
        return resultEntity;
    }

    @GetMapping("getRentOrderInfo/{orderId}")
    public ResultEntity<OrderInfoVo> getRentOrderInfo(@PathVariable Integer orderId) throws Exception {
        OrderInfoVo rentOrderInfo = orderService.getRentOrderInfo(orderId);
        ResultEntity<OrderInfoVo> resultEntity = new ResultEntity<>(rentOrderInfo);
        return resultEntity;
    }

    @GetMapping("getSaleOrderInfo/{orderId}")
    public ResultEntity<OrderInfoVo> getSaleOrderInfo(@PathVariable Integer orderId) throws Exception {
        OrderInfoVo rentOrderInfo = orderService.getSaleOrderInfo(orderId);
        ResultEntity<OrderInfoVo> resultEntity = new ResultEntity<>(rentOrderInfo);
        return resultEntity;
    }

    @PutMapping("toPayRentOrder")
    public ResultEntity<OrderInfoVo> toPayRentOrder(@RequestBody PayDto payDto) throws Exception {
        OrderInfoVo orderInfoVo = orderService.toPayRentOrder(payDto);
        ResultEntity<OrderInfoVo> resultEntity = new ResultEntity<>(orderInfoVo);
        return resultEntity;
    }

    @PutMapping("toPaySaleOrder")
    public ResultEntity<OrderInfoVo> toPaySaleOrder(@RequestBody PayDto payDto) throws Exception {
        OrderInfoVo orderInfoVo = orderService.toPaySaleOrder(payDto);
        ResultEntity<OrderInfoVo> resultEntity = new ResultEntity<>(orderInfoVo);
        return resultEntity;
    }

    @PutMapping("toRefundRentOrder")
    public ResultEntity<Integer> toRefundRentOrder(@RequestBody ToRefundDto toRefundDto) throws Exception {
        int count = orderService.toRefundRentOrder(toRefundDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PutMapping("toRefundSaleOrder")
    public ResultEntity<Integer> toRefundSaleOrder(@RequestBody ToRefundDto toRefundDto) throws Exception {
        int count = orderService.toRefundSaleOrder(toRefundDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PutMapping("toRentDelicery")
    public ResultEntity<Integer> toRentDelicery(@RequestBody ToDeliveryDto deliveryDto) throws Exception {
        int count = orderService.toRentDelicery(deliveryDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PutMapping("toSaleDelicery")
    public ResultEntity<Integer> toSaleDelicery(@RequestBody ToDeliveryDto deliveryDto) throws Exception {
        int count = orderService.toSaleDelicery(deliveryDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PutMapping("toConfirmRentOrder")
    public ResultEntity<OrderInfoVo> toConfirmRentOrder(@RequestBody ConfirmDto confirmDto) throws Exception {
        OrderInfoVo orderInfoVo = orderService.toConfirmRentOrder(confirmDto);
        ResultEntity<OrderInfoVo> resultEntity = new ResultEntity<>(orderInfoVo);
        return resultEntity;
    }

    @PutMapping("toConfirmSaleOrder")
    public ResultEntity<OrderInfoVo> toConfirmSaleOrder(@RequestBody ConfirmDto confirmDto) throws Exception {
        OrderInfoVo orderInfoVo = orderService.toConfirmSaleOrder(confirmDto);
        ResultEntity<OrderInfoVo> resultEntity = new ResultEntity<>(orderInfoVo);
        return resultEntity;
    }

    @PostMapping("toEvaluateRentOrder")
    public ResultEntity<OrderInfoVo> toEvaluateRentOrder(@RequestBody EvaluateDto evaluateDto) throws Exception {
        OrderInfoVo orderInfoVo = orderService.toEvaluateRentOrder(evaluateDto);
        ResultEntity<OrderInfoVo> resultEntity = new ResultEntity<>(orderInfoVo);
        return resultEntity;
    }

    @PostMapping("toEvaluateSaleOrder")
    public ResultEntity<OrderInfoVo> toEvaluateSaleOrder(@RequestBody EvaluateDto evaluateDto) throws Exception {
        OrderInfoVo orderInfoVo = orderService.toEvaluateSaleOrder(evaluateDto);
        ResultEntity<OrderInfoVo> resultEntity = new ResultEntity<>(orderInfoVo);
        return resultEntity;
    }
}
