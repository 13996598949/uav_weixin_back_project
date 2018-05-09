package com.lp.uav_weixin_back_project.uav_sale.service;

import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_sale.model.dto.SaleProductDto;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.SaleProductDetailVo;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.SaleProductVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SaleService {

    List<SaleProductVo> getSaleAllInfo(Integer userId);

    // 发布出售信息
    int insertSaleInfo(Integer userId, SaleProductDto saleProductDto) throws MyError;

    int insertSaleInfoPicture(Integer id, MultipartFile multipartFile) throws MyError;

    SaleProductDetailVo getSaleDetailInfo(Integer id, Integer userId);

    List<SaleProductVo> getMyPublishSale(Integer userId);

    int editSaleInfo(Integer id, SaleProductDto saleProductDto) throws MyError;

    int deleteMyPublishSale(Integer id);
}
