package com.lp.uav_weixin_back_project.uav_collect.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectRentVo;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectSaleVo;
import com.lp.uav_weixin_back_project.uav_collect.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public int insertCollectRent(Integer userId, Integer productId) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("productId",productId);
        map.put("createTime",new Date());
        map.put("lastUpdateTime",new Date());
        int count = baseDao.insert("com.lp.sqlMapper.collect.CollectRent.insertCollectRent",map);
        if (count<=0){
            throw new MyError("收藏失败！");
        }
        return count;
    }

    @Override
    public List<CollectRentVo> getCollectRent(Integer userId) {
        List<CollectRentVo> collectRentVos = baseDao.getList("com.lp.sqlMapper.collect.CollectRent.getCollectRent",userId);
        return collectRentVos;
    }

    @Override
    public Integer deleteCollectRent(Integer userId, Integer productId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("productId",productId);
        int count = baseDao.delete("com.lp.sqlMapper.collect.CollectRent.deleteCollectRent",map);
        return count;
    }

    @Override
    public int insertCollectSale(Integer userId, Integer productId) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("productId",productId);
        map.put("createTime",new Date());
        map.put("lastUpdateTime",new Date());
        int count = baseDao.insert("com.lp.sqlMapper.collect.CollectSale.insertCollectSale",map);
        if (count<=0){
            throw new MyError("收藏失败！");
        }
        return count;
    }

    @Override
    public List<CollectSaleVo> getCollectSale(Integer userId) {
        List<CollectSaleVo> collectSaleVos = baseDao.getList("com.lp.sqlMapper.collect.CollectSale.getCollectSale",userId);
        return collectSaleVos;
    }

    @Override
    public Integer deleteCollectSale(Integer userId, Integer productId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("productId",productId);
        int count = baseDao.delete("com.lp.sqlMapper.collect.CollectSale.deleteCollectSale",map);
        return count;
    }
}
