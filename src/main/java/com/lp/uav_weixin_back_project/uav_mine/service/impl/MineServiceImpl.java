package com.lp.uav_weixin_back_project.uav_mine.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.uav_mine.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineServiceImpl implements MineService {

    @Autowired
    private BaseDao baseDao;

}
