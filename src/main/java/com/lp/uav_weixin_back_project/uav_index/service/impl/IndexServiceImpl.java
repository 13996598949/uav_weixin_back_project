package com.lp.uav_weixin_back_project.uav_index.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectRentVo;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectSaleVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.SaleProductVo;
import com.lp.uav_weixin_back_project.uav_index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<RentProductVo> getRentInfo(Integer userId) {
        List<RentProductVo> rentProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getRentInfo",null);
        if (userId!=null && userId!=0){
            List<CollectRentVo> collectRentVos = baseDao.getList("com.lp.sqlMapper.collect.CollectRent.getCollectRent",userId);
            if (collectRentVos!=null && collectRentVos.size()>0){
                if (rentProductVoList!=null && rentProductVoList.size()>0){
                    for (RentProductVo productVo : rentProductVoList){
                        for (CollectRentVo collectRentVo : collectRentVos){
                            if (productVo.getId().equals(collectRentVo.getId())){
                                productVo.setCollectFlag(true);
                            }
                        }
                    }
                }
            }
        }

        return rentProductVoList;
    }

    @Override
    public List<SaleProductVo> getSaleInfo(Integer userId) {
        List<SaleProductVo> saleProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getSaleInfo",null);
        if (userId!=null && userId!=0){
            List<CollectSaleVo> collectSaleVos = baseDao.getList("com.lp.sqlMapper.collect.CollectSale.getCollectSale",userId);
            if (collectSaleVos!=null && collectSaleVos.size()>0){
                if (saleProductVoList!=null && saleProductVoList.size()>0){
                    for (SaleProductVo productVo : saleProductVoList){
                        for (CollectSaleVo collectSaleVo : collectSaleVos){
                            if (productVo.getId().equals(collectSaleVo.getId())){
                                productVo.setCollectFlag(true);
                            }
                        }
                    }
                }
            }
        }
        return saleProductVoList;
    }
}
