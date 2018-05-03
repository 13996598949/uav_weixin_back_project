package com.lp.uav_weixin_back_project.uav_mine.web;

import com.lp.uav_weixin_back_project.uav_mine.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mine")
public class MineController {

    @Autowired
    private MineService mineService;


}
