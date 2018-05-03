package com.lp.uav_weixin_back_project.uav_rent.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_rent.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("getRentAllInfo")
    public ResultEntity<List<RentProductVo>> getRentAllInfo() throws Exception {
        List<RentProductVo> rentProductVoList = rentService.getRentAllInfo();
        ResultEntity<List<RentProductVo>> resultEntity = new ResultEntity<>(rentProductVoList);
        return resultEntity;
    }
}
