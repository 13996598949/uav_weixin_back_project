package com.lp.uav_weixin_back_project.user.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.user.model.dto.*;
import com.lp.uav_weixin_back_project.user.model.vo.AddressCallbackListVo;
import com.lp.uav_weixin_back_project.user.model.vo.AddressListVo;
import com.lp.uav_weixin_back_project.user.model.vo.UserVo;
import com.lp.uav_weixin_back_project.user.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("login")
    public ResultEntity<UserVo> login(@RequestBody UserLoginDto userLoginDto) throws Exception {
        UserVo userVo = userService.login(userLoginDto);
        ResultEntity<UserVo> resultEntity = new ResultEntity<>(userVo);
        return resultEntity;
    }

    @PostMapping("register")
    public ResultEntity<Integer> register(@RequestBody UserDto userDto) throws Exception {
        int count = userService.register(userDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PutMapping("resetPassword")
    public ResultEntity<Integer> resetPassword(@RequestBody ResetDto resetDto) throws Exception {
        int count = userService.resetPassword(resetDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    // 发送短信验证码
    @PutMapping("sendVerification/{telephone}/{userName}")
    public ResultEntity<Integer> sendVerification(@PathVariable String telephone,@PathVariable String userName) throws Exception {
        Integer count = userService.sendVerification(telephone,userName);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PutMapping("editPersonInfo")
    public ResultEntity<UserVo> editPersonInfo(@RequestBody UserEditBasicDto userEditBasicDto) throws Exception {
        UserVo userVo = userService.editPersonInfo(userEditBasicDto);
        ResultEntity<UserVo> resultEntity = new ResultEntity<>(userVo);
        return resultEntity;
    }

    @PutMapping("editHeader/{id}")
    public ResultEntity<UserVo> editHeader(@PathVariable int id,@Param ("multipartFile") MultipartFile multipartFile) throws Exception {
        UserVo userVo = userService.editHeader(id,multipartFile);
        ResultEntity<UserVo> resultEntity = new ResultEntity<>(userVo);
        return resultEntity;
    }

    @PutMapping("editLoginPassword/{id}")
    public ResultEntity<Integer> editLoginPassword(@PathVariable int id,@RequestBody EditPasswordDto passwordDto) throws Exception {
        Integer count = userService.editLoginPassword(id,passwordDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PutMapping("editBuyPassword/{id}")
    public ResultEntity<Integer> editBuyPassword(@PathVariable int id,@RequestBody EditPasswordDto passwordDto) throws Exception {
        Integer count = userService.editBuyPassword(id,passwordDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @GetMapping("getAddressList/{userId}")
    public ResultEntity<List<AddressCallbackListVo>> getAddressList(@PathVariable int userId) throws Exception {
        List<AddressCallbackListVo> addressList = userService.getAddressList(userId);
        ResultEntity<List<AddressCallbackListVo>> resultEntity = new ResultEntity<>(addressList);
        return resultEntity;
    }

    @PostMapping("insertAddress/{userId}")
    public ResultEntity<Integer> insertAddress(@PathVariable int userId, @RequestBody AddressDto addressDto) throws Exception {
        int count = userService.insertAddress(userId, addressDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @GetMapping("getAddressById/{id}")
    public ResultEntity<AddressListVo> getAddressById(@PathVariable int id) throws Exception {
        AddressListVo addressList = userService.getAddressById(id);
        ResultEntity<AddressListVo> resultEntity = new ResultEntity<>(addressList);
        return resultEntity;
    }

    @PutMapping("editAddress/{id}")
    public ResultEntity<Integer> editAddress(@PathVariable int id, @RequestBody AddressDto addressDto) throws Exception {
        int count = userService.editAddress(id, addressDto);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @DeleteMapping("deleteAddress/{id}")
    public ResultEntity<Integer> deleteAddress(@PathVariable int id) throws Exception {
        int count = userService.deleteAddress(id);
        ResultEntity<Integer> resultEntity = new ResultEntity<>(count);
        return resultEntity;
    }

    @PutMapping("updateAccount")
    public ResultEntity<UserVo> updateAccount(@RequestBody AccountDto accountDto) throws Exception {
        UserVo userVo = userService.updateAccount(accountDto);
        ResultEntity<UserVo> resultEntity = new ResultEntity<>(userVo);
        return resultEntity;
    }
}
