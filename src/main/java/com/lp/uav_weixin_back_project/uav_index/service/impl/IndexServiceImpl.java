package com.lp.uav_weixin_back_project.uav_index.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.uav_index.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.SaleProductVo;
import com.lp.uav_weixin_back_project.uav_index.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<RentProductVo> getRentInfo() {
        List<RentProductVo> rentProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getRentInfo",null);
        return rentProductVoList;
    }

    @Override
    public List<SaleProductVo> getSaleInfo() {
        List<SaleProductVo> saleProductVoList = baseDao.getList("com.lp.sqlMapper.index.RentProduct.getSaleInfo",null);
        return saleProductVoList;
    }
}
