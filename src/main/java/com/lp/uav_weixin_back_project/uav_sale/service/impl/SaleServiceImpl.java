package com.lp.uav_weixin_back_project.uav_sale.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.SaleProductVo;
import com.lp.uav_weixin_back_project.uav_sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<SaleProductVo> getSaleAllInfo() {
        List<SaleProductVo> saleProductVoList = baseDao.getList("com.lp.sqlMapper.sale.SaleProduct.getSaleAllInfo",null);
        return saleProductVoList;
    }
}
