package com.lp.uav_weixin_back_project.uav_index.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_index.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.SaleProductVo;
import com.lp.uav_weixin_back_project.uav_index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("getRentInfo/{userId}")
    public ResultEntity<List<RentProductVo>> getRentInfo(@PathVariable Integer userId) throws Exception {
        List<RentProductVo> rentProductVoList = indexService.getRentInfo(userId);
        ResultEntity<List<RentProductVo>> resultEntity = new ResultEntity<>(rentProductVoList);
        return resultEntity;
    }

    @GetMapping("getSaleInfo/{userId}")
    public ResultEntity<List<SaleProductVo>> getSaleInfo(@PathVariable Integer userId) throws Exception {
        List<SaleProductVo> saleProductVoList = indexService.getSaleInfo(userId);
        ResultEntity<List<SaleProductVo>> resultEntity = new ResultEntity<>(saleProductVoList);
        return resultEntity;
    }

    @GetMapping("getRecommendRent/{userId}")
    public ResultEntity<List<RentProductVo>> getRecommendRent(@PathVariable Integer userId) throws Exception {
        List<RentProductVo> rentProductVoList = indexService.getRecommendRent(userId);
        ResultEntity<List<RentProductVo>> resultEntity = new ResultEntity<>(rentProductVoList);
        return resultEntity;
    }

    @GetMapping("getRecommendSale/{userId}")
    public ResultEntity<List<SaleProductVo>> getRecommendSale(@PathVariable Integer userId) throws Exception {
        List<SaleProductVo> saleProductVoList = indexService.getRecommendSale(userId);
        ResultEntity<List<SaleProductVo>> resultEntity = new ResultEntity<>(saleProductVoList);
        return resultEntity;
    }

    @GetMapping("getNewRent/{userId}")
    public ResultEntity<List<RentProductVo>> getNewRent(@PathVariable Integer userId) throws Exception {
        List<RentProductVo> rentProductVoList = indexService.getNewRent(userId);
        ResultEntity<List<RentProductVo>> resultEntity = new ResultEntity<>(rentProductVoList);
        return resultEntity;
    }

    @GetMapping("getNewSale/{userId}")
    public ResultEntity<List<SaleProductVo>> getNewSale(@PathVariable Integer userId) throws Exception {
        List<SaleProductVo> saleProductVoList = indexService.getNewSale(userId);
        ResultEntity<List<SaleProductVo>> resultEntity = new ResultEntity<>(saleProductVoList);
        return resultEntity;
    }

    @GetMapping("getConsumerRent/{userId}")
    public ResultEntity<List<RentProductVo>> getConsumerRent(@PathVariable Integer userId) throws Exception {
        List<RentProductVo> rentProductVoList = indexService.getConsumerRent(userId);
        ResultEntity<List<RentProductVo>> resultEntity = new ResultEntity<>(rentProductVoList);
        return resultEntity;
    }

    @GetMapping("getConsumerSale/{userId}")
    public ResultEntity<List<SaleProductVo>> getConsumerSale(@PathVariable Integer userId) throws Exception {
        List<SaleProductVo> saleProductVoList = indexService.getConsumerSale(userId);
        ResultEntity<List<SaleProductVo>> resultEntity = new ResultEntity<>(saleProductVoList);
        return resultEntity;
    }

    @GetMapping("getProfessionalRent/{userId}")
    public ResultEntity<List<RentProductVo>> getProfessionalRent(@PathVariable Integer userId) throws Exception {
        List<RentProductVo> rentProductVoList = indexService.getProfessionalRent(userId);
        ResultEntity<List<RentProductVo>> resultEntity = new ResultEntity<>(rentProductVoList);
        return resultEntity;
    }

    @GetMapping("getProfessionalSale/{userId}")
    public ResultEntity<List<SaleProductVo>> getProfessionalSale(@PathVariable Integer userId) throws Exception {
        List<SaleProductVo> saleProductVoList = indexService.getProfessionalSale(userId);
        ResultEntity<List<SaleProductVo>> resultEntity = new ResultEntity<>(saleProductVoList);
        return resultEntity;
    }
}
