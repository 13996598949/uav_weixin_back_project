package com.lp.uav_weixin_back_project.uav_index.web;

import com.github.pagehelper.Page;
import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_index.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.SaleProductVo;
import com.lp.uav_weixin_back_project.uav_index.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

}
