package com.lp.uav_weixin_back_project.uav_rent.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_rent.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<RentProductVo> getRentAllInfo() {
        List<RentProductVo> rentProductVoList = baseDao.getList("com.lp.sqlMapper.rent.RentProduct.getRentAllInfo",null);
        return rentProductVoList;
    }
}
