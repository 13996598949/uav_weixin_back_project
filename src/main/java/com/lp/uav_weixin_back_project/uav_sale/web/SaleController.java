package com.lp.uav_weixin_back_project.uav_sale.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.SaleProductVo;
import com.lp.uav_weixin_back_project.uav_sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
