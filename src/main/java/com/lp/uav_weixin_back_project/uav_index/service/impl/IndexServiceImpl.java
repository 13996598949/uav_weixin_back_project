package com.lp.uav_weixin_back_project.uav_index.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectRentVo;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectSaleVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.SaleProductVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.TypeVo;
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
        getCollectRent(userId, rentProductVoList);

        return rentProductVoList;
    }

    @Override
    public List<SaleProductVo> getSaleInfo(Integer userId) {
        List<SaleProductVo> saleProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getSaleInfo",null);
        getCollectSale(userId, saleProductVoList);
        return saleProductVoList;
    }

    @Override
    public List<RentProductVo> getRecommendRent(Integer userId, String searchName) {
        if (searchName!=null && !searchName.equals("")){
            searchName = searchName.replaceAll("'","");
        }
        List<RentProductVo> recommendVos;
        if (userId!=null && userId!=0) {
            // 用户已登录  根据喜好推荐

            // 获取该用户偏好的商品类型
            TypeVo typeVo = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getUserLikeType", userId);
            int likeType = 0;
            if (typeVo != null) {
                if (typeVo.getConsumer() >= typeVo.getProfessional()) {
                    likeType = 0;
                } else {
                    likeType = 1;
                }
            }

            // 获取用户偏好的商品类型的各商品浏览量和发布时间  过滤自己发布的商品
            Map<String, Object> map = new HashMap<>();
            map.put("type", likeType);
            map.put("userId", userId);
            map.put("searchName",searchName);
            recommendVos = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getRecommendRentVo", map);
            if (recommendVos != null && recommendVos.size() > 0) {
                Date currentTime = new Date();
                for (RentProductVo vo : recommendVos){
                    // 计算每个商品的得分
                    float sorce = vo.getViewNum()/(currentTime.getTime()-vo.getCreateTime().getTime());
                    vo.setSocre(sorce);
                }
            }
            // 根据得分对商品ID进行排序
            Collections.sort(recommendVos, new Comparator<RentProductVo>() {
                @Override
                public int compare(RentProductVo o1, RentProductVo o2) {
                    if (o1.getSocre() < o2.getSocre()){
                        return 1;
                    }
                    if (o1.getSocre() == o2.getSocre()){
                        return 0;
                    }
                    return -1;
                }
            });

        }else {
            Map<String,Object> map = new HashMap<>();
            map.put("searchName",searchName);
            // 用户未登录  按浏览量推荐
            recommendVos = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getRentByViewNum",map);
        }

        getCollectRent(userId, recommendVos);
        return recommendVos;

    }

    @Override
    public List<SaleProductVo> getRecommendSale(Integer userId, String searchName) {
        if (searchName!=null && !searchName.equals("")){
            searchName = searchName.replaceAll("'","");
        }
        List<SaleProductVo> recommendVos;
        if (userId!=null && userId!=0) {
            // 用户已登录  根据喜好推荐

            // 获取该用户偏好的商品类型
            TypeVo typeVo = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getUserLikeType", userId);
            int likeType = 0;
            if (typeVo != null) {
                if (typeVo.getConsumer() >= typeVo.getProfessional()) {
                    likeType = 0;
                } else {
                    likeType = 1;
                }
            }

            // 获取用户偏好的商品类型的各商品浏览量和发布时间  过滤自己发布的商品
            Map<String, Object> map = new HashMap<>();
            map.put("type", likeType);
            map.put("userId", userId);
            map.put("searchName",searchName);
            recommendVos = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getRecommendSaleVo", map);
            if (recommendVos != null && recommendVos.size() > 0) {
                Date currentTime = new Date();
                for (SaleProductVo vo : recommendVos){
                    // 计算每个商品的得分
                    long date = (currentTime.getTime()-vo.getCreateTime().getTime())/1000;
                    float sorce = ((vo.getViewNum()*10000)/date);
                    vo.setSocre(sorce);
                }
            }
            // 根据得分对商品ID进行排序
            Collections.sort(recommendVos, new Comparator<SaleProductVo>() {
                @Override
                public int compare(SaleProductVo o1, SaleProductVo o2) {
                    if (o1.getSocre() < o2.getSocre()){
                        return 1;
                    }
                    if (o1.getSocre() == o2.getSocre()){
                        return 0;
                    }
                    return -1;
                }
            });
        }else {
            Map<String,Object> map = new HashMap<>();
            map.put("searchName",searchName);
            // 用户未登录  按浏览量推荐
            recommendVos = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getSaleByViewNum",map);
        }

        getCollectSale(userId, recommendVos);

        return recommendVos;
    }

    @Override
    public List<RentProductVo> getNewRent(Integer userId, String searchName) {
        if (searchName!=null && !searchName.equals("")){
            searchName = searchName.replaceAll("'","");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("searchName",searchName);
        List<RentProductVo> rentProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getNewRent",map);
        getCollectRent(userId, rentProductVoList);
        return rentProductVoList;
    }

    @Override
    public List<SaleProductVo> getNewSale(Integer userId, String searchName) {
        if (searchName!=null && !searchName.equals("")){
            searchName = searchName.replaceAll("'","");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("searchName",searchName);
        List<SaleProductVo> saleProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getNewSale",map);
        getCollectSale(userId, saleProductVoList);
        return saleProductVoList;
    }

    @Override
    public List<RentProductVo> getConsumerRent(Integer userId, String searchName) {
        if (searchName!=null && !searchName.equals("")){
            searchName = searchName.replaceAll("'","");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("searchName",searchName);
        List<RentProductVo> rentProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getConsumerRent",map);
        getCollectRent(userId, rentProductVoList);
        return rentProductVoList;
    }

    @Override
    public List<SaleProductVo> getConsumerSale(Integer userId, String searchName) {
        if (searchName!=null && !searchName.equals("")){
            searchName = searchName.replaceAll("'","");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("searchName",searchName);
        List<SaleProductVo> saleProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getConsumerSale",map);
        getCollectSale(userId, saleProductVoList);
        return saleProductVoList;
    }

    @Override
    public List<RentProductVo> getProfessionalRent(Integer userId, String searchName) {
        if (searchName!=null && !searchName.equals("")){
            searchName = searchName.replaceAll("'","");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("searchName",searchName);
        List<RentProductVo> rentProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getProfessionalRent",map);
        getCollectRent(userId, rentProductVoList);
        return rentProductVoList;
    }

    @Override
    public List<SaleProductVo> getProfessionalSale(Integer userId, String searchName) {
        if (searchName!=null && !searchName.equals("")){
            searchName = searchName.replaceAll("'","");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("searchName",searchName);
        List<SaleProductVo> saleProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getProfessionalSale",map);
        getCollectSale(userId, saleProductVoList);
        return saleProductVoList;
    }

    private void getCollectRent(Integer userId, List<RentProductVo> rentProductVoList) {
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
    }

    private void getCollectSale(Integer userId, List<SaleProductVo> saleProductVoList) {
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
    }
}
