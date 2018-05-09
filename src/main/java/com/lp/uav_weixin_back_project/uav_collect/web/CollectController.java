package com.lp.uav_weixin_back_project.uav_collect.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectRentVo;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectSaleVo;
import com.lp.uav_weixin_back_project.uav_collect.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @PostMapping("insertCollectRent/{userId}/{productId}")
    public ResultEntity<Integer> insertCollectRent(@PathVariable Integer userId, @PathVariable Integer productId) throws Exception {
        int id = collectService.insertCollectRent(userId,productId);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(id);
        return resultEntity;
    }

    @GetMapping("getCollectRent/{userId}")
    public ResultEntity<List<CollectRentVo>> getCollectRent(@PathVariable Integer userId) throws Exception {
        List<CollectRentVo> collectRentVos = collectService.getCollectRent(userId);
        ResultEntity<List<CollectRentVo>> resultEntity = new ResultEntity<>(collectRentVos);
        return resultEntity;
    }

    @DeleteMapping("deleteCollectRent/{userId}/{productId}")
    public ResultEntity<Integer> deleteCollectRent(@PathVariable Integer userId,@PathVariable Integer productId) throws Exception {
        Integer count = collectService.deleteCollectRent(userId,productId);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PostMapping("insertCollectSale/{userId}/{productId}")
    public ResultEntity<Integer> insertCollectSale(@PathVariable Integer userId, @PathVariable Integer productId) throws Exception {
        int id = collectService.insertCollectSale(userId,productId);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(id);
        return resultEntity;
    }

    @GetMapping("getCollectSale/{userId}")
    public ResultEntity<List<CollectSaleVo>> getCollectSale(@PathVariable Integer userId) throws Exception {
        List<CollectSaleVo> collectSaleVos = collectService.getCollectSale(userId);
        ResultEntity<List<CollectSaleVo>> resultEntity = new ResultEntity<>(collectSaleVos);
        return resultEntity;
    }

    @DeleteMapping("deleteCollectSale/{userId}/{productId}")
    public ResultEntity<Integer> deleteCollectSale(@PathVariable Integer userId,@PathVariable Integer productId) throws Exception {
        Integer count = collectService.deleteCollectSale(userId,productId);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

}
