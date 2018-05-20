package com.lp.uav_weixin_back_project.uav_order.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_order.model.dto.*;
import com.lp.uav_weixin_back_project.uav_order.model.vo.*;
import com.lp.uav_weixin_back_project.uav_order.service.OrderService;
import com.lp.uav_weixin_back_project.user.model.vo.UserVo;
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

    @DeleteMapping("deleteRentOrder/{orderId}/{flag}")
    public ResultEntity<Integer> deleteRentOrder(@PathVariable Integer orderId,@PathVariable String flag) throws Exception {
        int count = orderService.deleteRentOrder(orderId,flag);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @DeleteMapping("deleteSaleOrder/{orderId}/{flag}")
    public ResultEntity<Integer> deleteSaleOrder(@PathVariable Integer orderId,@PathVariable String flag) throws Exception {
        int count = orderService.deleteSaleOrder(orderId,flag);
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
    public ResultEntity<UserVo> toRefundRentOrder(@RequestBody ToRefundDto toRefundDto) throws Exception {
        UserVo userVo = orderService.toRefundRentOrder(toRefundDto);
        ResultEntity<UserVo> resultEntity = new ResultEntity<>(userVo);
        return resultEntity;
    }

    @PutMapping("toRefundSaleOrder")
    public ResultEntity<UserVo> toRefundSaleOrder(@RequestBody ToRefundDto toRefundDto) throws Exception {
        UserVo userVo = orderService.toRefundSaleOrder(toRefundDto);
        ResultEntity<UserVo> resultEntity = new ResultEntity<>(userVo);
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

    @GetMapping("getEvaluateRentInfo/{orderId}")
    public ResultEntity<List<EvaluateInfoVo>> getEvaluateRentInfo(@PathVariable Integer orderId) throws Exception {
        List<EvaluateInfoVo> evaluateInfoVos = orderService.getEvaluateRentInfo(orderId);
        ResultEntity<List<EvaluateInfoVo>> resultEntity = new ResultEntity<>(evaluateInfoVos);
        return resultEntity;
    }

    @GetMapping("getEvaluateSaleInfo/{orderId}")
    public ResultEntity<List<EvaluateInfoVo>> getEvaluateSaleInfo(@PathVariable Integer orderId) throws Exception {
        List<EvaluateInfoVo> evaluateInfoVos = orderService.getEvaluateSaleInfo(orderId);
        ResultEntity<List<EvaluateInfoVo>> resultEntity = new ResultEntity<>(evaluateInfoVos);
        return resultEntity;
    }

    @GetMapping("countOrderNum/{userId}")
    public ResultEntity<CountOrderVo> countOrderNum(@PathVariable Integer userId) throws Exception {
        CountOrderVo countOrderVo = orderService.countOrderNum(userId);
        ResultEntity<CountOrderVo> resultEntity = new ResultEntity<>(countOrderVo);
        return resultEntity;
    }

    @GetMapping("getPayingRentList/{userId}")
    public ResultEntity<List<MySellInfoVo>> getPayingRentList(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> payingRentList = orderService.getPayingRentList(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(payingRentList);
        return resultEntity;
    }

    @GetMapping("getPayingSaleList/{userId}")
    public ResultEntity<List<MySellInfoVo>> getPayingSaleList(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> payingSaleList = orderService.getPayingSaleList(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(payingSaleList);
        return resultEntity;
    }

    @GetMapping("getDeliveryRentList/{userId}")
    public ResultEntity<List<MySellInfoVo>> getDeliveryRentList(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> deliveryRentList = orderService.getDeliveryRentList(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(deliveryRentList);
        return resultEntity;
    }

    @GetMapping("getDeliverySaleList/{userId}")
    public ResultEntity<List<MySellInfoVo>> getDeliverySaleList(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> deliverySaleList = orderService.getDeliverySaleList(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(deliverySaleList);
        return resultEntity;
    }

    @GetMapping("getConfirmRentList/{userId}")
    public ResultEntity<List<MySellInfoVo>> getConfirmRentList(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> confirmRentList = orderService.getConfirmRentList(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(confirmRentList);
        return resultEntity;
    }

    @GetMapping("getConfirmSaleList/{userId}")
    public ResultEntity<List<MySellInfoVo>> getConfirmSaleList(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> confirmSaleList = orderService.getConfirmSaleList(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(confirmSaleList);
        return resultEntity;
    }

    @GetMapping("getEvaluateRentList/{userId}")
    public ResultEntity<List<MySellInfoVo>> getEvaluateRentList(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> evaluateRentList = orderService.getEvaluateRentList(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(evaluateRentList);
        return resultEntity;
    }

    @GetMapping("getEvaluateSaleList/{userId}")
    public ResultEntity<List<MySellInfoVo>> getEvaluateSaleList(@PathVariable Integer userId) throws Exception {
        List<MySellInfoVo> evaluateSaleList = orderService.getEvaluateSaleList(userId);
        ResultEntity<List<MySellInfoVo>> resultEntity = new ResultEntity<>(evaluateSaleList);
        return resultEntity;
    }

    @PutMapping("toRefundDeposit")
    public ResultEntity<Integer> toRefundDeposit(@RequestBody RefundDepositDto depositDto) throws Exception {
        int count = orderService.toRefundDeposit(depositDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @GetMapping("getRefundDepositInfo/{orderId}")
    public ResultEntity<RefundDepositVo> getRefundDepositInfo(@PathVariable Integer orderId) throws Exception {
        RefundDepositVo refundDepositVo = orderService.getRefundDepositInfo(orderId);
        ResultEntity<RefundDepositVo> resultEntity = new ResultEntity<>(refundDepositVo);
        return resultEntity;
    }
}
