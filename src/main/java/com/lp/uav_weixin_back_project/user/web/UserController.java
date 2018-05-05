package com.lp.uav_weixin_back_project.user.web;

import com.lp.uav_weixin_back_project.model.ResultEntity;
import com.lp.uav_weixin_back_project.user.model.dto.UserDto;
import com.lp.uav_weixin_back_project.user.model.dto.UserEditBasicDto;
import com.lp.uav_weixin_back_project.user.model.dto.UserLoginDto;
import com.lp.uav_weixin_back_project.user.model.vo.UserVo;
import com.lp.uav_weixin_back_project.user.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

}
