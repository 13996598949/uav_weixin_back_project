package com.lp.uav_weixin_back_project.uav_sale.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_sale.model.dto.SaleProductDto;
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

    @GetMapping("getSaleAllInfo")
    public ResultEntity<List<SaleProductVo>> getRentAllInfo() throws Exception {
        List<SaleProductVo> saleProductVoList = saleService.getSaleAllInfo();
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
}
