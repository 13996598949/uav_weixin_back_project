package com.lp.uav_weixin_back_project.user.service;

import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.user.model.dto.UserDto;
import com.lp.uav_weixin_back_project.user.model.dto.UserEditBasicDto;
import com.lp.uav_weixin_back_project.user.model.dto.UserLoginDto;
import com.lp.uav_weixin_back_project.user.model.vo.UserVo;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    // 注册
    int register(UserDto userDto) throws Exception;

    // 登录
    UserVo login(UserLoginDto userLoginDto) throws MyError;

    // 修改个人中心
    UserVo editPersonInfo(UserEditBasicDto userEditBasicDto) throws Exception;

    // 修改头像
    UserVo editHeader(int id, MultipartFile multipartFile) throws MyError;
}
