package com.lp.uav_weixin_back_project.uav_sale.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_sale.model.dto.SaleProductDto;
import com.lp.uav_weixin_back_project.uav_sale.model.dto.SaleRecordNumDto;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.SaleProductDetailVo;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.SaleProductVo;
import com.lp.uav_weixin_back_project.uav_sale.service.SaleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("getSaleAllInfo/{userId}")
    public ResultEntity<List<SaleProductVo>> getRentAllInfo(@PathVariable Integer userId) throws Exception {
        List<SaleProductVo> saleProductVoList = saleService.getSaleAllInfo(userId);
        ResultEntity<List<SaleProductVo>> resultEntity = new ResultEntity<>(saleProductVoList);
        return resultEntity;
    }

    @PostMapping("insertSaleInfo/{userId}")
    public ResultEntity<Integer> insertSaleInfo(@PathVariable Integer userId, @RequestBody SaleProductDto saleProductDto) throws Exception {
        int id = saleService.insertSaleInfo(userId,saleProductDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(id);
        return resultEntity;
    }

    @PutMapping("insertSaleInfoPicture/{id}")
    public ResultEntity<Integer> insertSaleInfoPicture(@PathVariable Integer id,@Param("multipartFile")MultipartFile multipartFile) throws Exception {
        int count = saleService.insertSaleInfoPicture(id,multipartFile);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @GetMapping("getSaleDetailInfo/{id}/{userId}")
    public ResultEntity<SaleProductDetailVo> getSaleDetailInfo(@PathVariable Integer id,@PathVariable Integer userId) throws Exception {
        SaleProductDetailVo saleDetailInfo = saleService.getSaleDetailInfo(id,userId);
        ResultEntity<SaleProductDetailVo> resultEntity = new ResultEntity<>(saleDetailInfo);
        return resultEntity;
    }

    @GetMapping("getMyPublishSale/{userId}")
    public ResultEntity<List<SaleProductVo>> getMyPublishSale(@PathVariable Integer userId) throws Exception {
        List<SaleProductVo> saleProductVoList = saleService.getMyPublishSale(userId);
        ResultEntity<List<SaleProductVo>> resultEntity = new ResultEntity<>(saleProductVoList);
        return resultEntity;
    }

    @PutMapping("editSaleInfo/{id}")
    public ResultEntity<Integer> editSaleInfo(@PathVariable Integer id,@RequestBody SaleProductDto saleProductDto) throws Exception {
        int count = saleService.editSaleInfo(id,saleProductDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @DeleteMapping("deleteMyPublishSale/{id}")
    public ResultEntity<Integer> deleteMyPublishSale(@PathVariable Integer id) throws Exception {
        int count = saleService.deleteMyPublishSale(id);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @GetMapping("getSaleSimpleInfo/{id}")
    public ResultEntity<SaleProductDetailVo> getSaleSimpleInfo(@PathVariable Integer id) throws Exception {
        SaleProductDetailVo saleSimpleInfo = saleService.getSaleSimpleInfo(id);
        ResultEntity<SaleProductDetailVo> resultEntity = new ResultEntity<>(saleSimpleInfo);
        return resultEntity;
    }

    @PutMapping("recordSaleNum")
    public ResultEntity<Integer> recordSaleNum(@RequestBody SaleRecordNumDto saleRecordNumDto) throws Exception {
        Integer count = saleService.recordSaleNum(saleRecordNumDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }
}
