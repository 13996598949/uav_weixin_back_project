package com.lp.uav_weixin_back_project.uav_rent.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.uav_rent.model.dto.RentMessageDto;
import com.lp.uav_weixin_back_project.uav_rent.model.dto.RentProductDto;
import com.lp.uav_weixin_back_project.uav_rent.model.dto.RentRecordNumDto;
import com.lp.uav_weixin_back_project.uav_rent.model.dto.RentReplyDto;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.MyMessageRentVo;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentMessageVo;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentProductDetailVo;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_rent.service.RentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("getRentAllInfo/{userId}")
    public ResultEntity<List<RentProductVo>> getRentAllInfo(@PathVariable Integer userId,String rentName) throws Exception {
        List<RentProductVo> rentProductVoList = rentService.getRentAllInfo(userId,rentName);
        ResultEntity<List<RentProductVo>> resultEntity = new ResultEntity<>(rentProductVoList);
        return resultEntity;
    }

    @PostMapping("insertRentInfo/{userId}")
    public ResultEntity<Integer> insertRentInfo(@PathVariable Integer userId,@RequestBody RentProductDto rentProductDto) throws Exception {
        int id = rentService.insertRentInfo(userId,rentProductDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(id);
        return resultEntity;
    }

    @PutMapping("insertRentInfoPicture/{id}")
    public ResultEntity<Integer> insertRentInfoPicture(@PathVariable Integer id,@Param("multipartFile")MultipartFile multipartFile) throws Exception {
        int count = rentService.insertRentInfoPicture(id,multipartFile);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @GetMapping("getRentDetailInfo/{id}/{userId}")
    public ResultEntity<RentProductDetailVo> getRentDetailInfo(@PathVariable Integer id,@PathVariable Integer userId) throws Exception {
        RentProductDetailVo rentDetailInfo = rentService.getRentDetailInfo(id,userId);
        ResultEntity<RentProductDetailVo> resultEntity = new ResultEntity<>(rentDetailInfo);
        return resultEntity;
    }

    @GetMapping("getMyPublishRent/{userId}")
    public ResultEntity<List<RentProductVo>> getMyPublishRent(@PathVariable Integer userId) throws Exception {
        List<RentProductVo> rentProductVoList = rentService.getMyPublishRent(userId);
        ResultEntity<List<RentProductVo>> resultEntity = new ResultEntity<>(rentProductVoList);
        return resultEntity;
    }

    @PutMapping("editRentInfo/{id}")
    public ResultEntity<Integer> editRentInfo(@PathVariable Integer id,@RequestBody RentProductDto rentProductDto) throws Exception {
        int count = rentService.editRentInfo(id,rentProductDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @DeleteMapping("deleteMyPublishRent/{id}")
    public ResultEntity<Integer> deleteMyPublishRent(@PathVariable Integer id) throws Exception {
        int count = rentService.deleteMyPublishRent(id);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @GetMapping("getRentSimpleInfo/{id}")
    public ResultEntity<RentProductDetailVo> getRentSimpleInfo(@PathVariable Integer id) throws Exception {
        RentProductDetailVo rentDetailInfo = rentService.getRentSimpleInfo(id);
        ResultEntity<RentProductDetailVo> resultEntity = new ResultEntity<>(rentDetailInfo);
        return resultEntity;
    }

    @PutMapping("recordRentNum")
    public ResultEntity<Integer> recordRentNum(@RequestBody RentRecordNumDto recordNumDto) throws Exception {
        Integer count = rentService.recordRentNum(recordNumDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PostMapping("insertRentMessage")
    public ResultEntity<Integer> insertRentMessage(@RequestBody RentMessageDto messageDto) throws Exception {
        int count = rentService.insertRentMessage(messageDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @GetMapping("getRentMessage/{productId}")
    public ResultEntity<List<RentMessageVo>> getRentMessage(@PathVariable Integer productId) throws Exception {
        List<RentMessageVo> rentMessage = rentService.getRentMessage(productId);
        ResultEntity<List<RentMessageVo>> resultEntity = new ResultEntity<>(rentMessage);
        return resultEntity;
    }

    @GetMapping("getMyMessageRentInfo/{userId}")
    public ResultEntity<List<MyMessageRentVo>> getMyMessageRentInfo(@PathVariable Integer userId) throws Exception {
        List<MyMessageRentVo> myMessageRentInfo = rentService.getMyMessageRentInfo(userId);
        ResultEntity<List<MyMessageRentVo>> resultEntity = new ResultEntity<>(myMessageRentInfo);
        return resultEntity;
    }

    @PutMapping("replyRentMessage")
    public ResultEntity<Integer> replyRentMessage(@RequestBody RentReplyDto rentReplyDto) throws Exception {
        int count = rentService.replyRentMessage(rentReplyDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }
}
