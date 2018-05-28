package com.lp.uav_weixin_back_project.user.service;

import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.user.model.dto.*;
import com.lp.uav_weixin_back_project.user.model.vo.AddressCallbackListVo;
import com.lp.uav_weixin_back_project.user.model.vo.AddressListVo;
import com.lp.uav_weixin_back_project.user.model.vo.UserVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    // 注册
    int register(UserDto userDto) throws Exception;

    // 登录
    UserVo login(UserLoginDto userLoginDto) throws MyError;

    // 修改个人中心
    UserVo editPersonInfo(UserEditBasicDto userEditBasicDto) throws Exception;

    // 修改头像
    UserVo editHeader(int id, MultipartFile multipartFile) throws MyError;

    // 修改登录密码
    Integer editLoginPassword(int id, EditPasswordDto passwordDto) throws MyError;

    // 修改交易密码
    Integer editBuyPassword(int id, EditPasswordDto passwordDto) throws MyError;

    // 获取收货地址列表
    List<AddressCallbackListVo> getAddressList(int userId);

    // 新增收货地址
    int insertAddress(int userId, AddressDto addressDto) throws MyError;

    // 修改收货地址
    int editAddress(int id, AddressDto addressDto) throws MyError;

    // 获取收货地址详细信息
    AddressListVo getAddressById(int id);

    // 删除收货地址
    int deleteAddress(int id);

    Integer sendVerification(String telephone, String userName) throws MyError;

    int resetPassword(ResetDto resetDto) throws MyError;

    UserVo updateAccount(AccountDto accountDto) throws MyError;

    UserVo getUserInfoById(int id);
}
