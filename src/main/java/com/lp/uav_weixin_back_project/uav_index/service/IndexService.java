package com.lp.uav_weixin_back_project.uav_index.service;

import com.github.pagehelper.Page;
import com.lp.uav_weixin_back_project.uav_index.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_index.model.vo.SaleProductVo;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IndexService {

    List<RentProductVo> getRentInfo();

    List<SaleProductVo> getSaleInfo();
}
