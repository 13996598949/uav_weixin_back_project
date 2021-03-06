package com.lp.uav_weixin_back_project.uav_rent.service;

import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_rent.model.dto.RentMessageDto;
import com.lp.uav_weixin_back_project.uav_rent.model.dto.RentProductDto;
import com.lp.uav_weixin_back_project.uav_rent.model.dto.RentRecordNumDto;
import com.lp.uav_weixin_back_project.uav_rent.model.dto.RentReplyDto;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.MyMessageRentVo;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentMessageVo;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentProductDetailVo;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentProductVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RentService {

    List<RentProductVo> getRentAllInfo(Integer userId,String rentName);

    // 发布租赁信息
    int insertRentInfo(Integer userId, RentProductDto rentProductDto) throws MyError;

    // 上传图片
    int insertRentInfoPicture(Integer id, MultipartFile multipartFile) throws MyError;

    // 商品详细信息
    RentProductDetailVo getRentDetailInfo(Integer userId, Integer id);

    List<RentProductVo> getMyPublishRent(Integer userId);

    int editRentInfo(Integer id, RentProductDto rentProductDto) throws MyError;

    int deleteMyPublishRent(Integer id) throws MyError;

    RentProductDetailVo getRentSimpleInfo(Integer id);

    Integer recordRentNum(RentRecordNumDto recordNumDto) throws Exception;

    int insertRentMessage(RentMessageDto rentMessageDto) throws MyError;

    List<RentMessageVo> getRentMessage(Integer productId);

    List<MyMessageRentVo> getMyMessageRentInfo(Integer userId);

    int replyRentMessage(RentReplyDto rentReplyDto);
}
