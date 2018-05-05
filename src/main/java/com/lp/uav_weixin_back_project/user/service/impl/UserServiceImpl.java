package com.lp.uav_weixin_back_project.user.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.user.model.dto.UserDto;
import com.lp.uav_weixin_back_project.user.model.dto.UserEditBasicDto;
import com.lp.uav_weixin_back_project.user.model.dto.UserLoginDto;
import com.lp.uav_weixin_back_project.user.model.vo.UserVo;
import com.lp.uav_weixin_back_project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public int register(UserDto userDto) throws Exception {

        // 校验用户名是否存在
        List<UserVo> userList = baseDao.getList("com.lp.sqlMapper.user.User.getUser",userDto);
        if (userList!=null && userList.size()>0) {
            throw new MyError("用户名已存在");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("personName", userDto.getPersonName());
        map.put("userName", userDto.getUserName());
        map.put("loginPassword", userDto.getLoginPassword());
        map.put("buyPassword", userDto.getBuyPassword());
        map.put("mail", userDto.getMail());
        map.put("telephone", userDto.getTelephone());
        map.put("header","header/header.jpg");
        int count = baseDao.insert("com.lp.sqlMapper.user.User.register", map);
        return count;
    }

    @Override
    public UserVo login(UserLoginDto userLoginDto) throws MyError {
        UserVo userVo = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getUserByPassword",userLoginDto);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(userVo.getBirthday());
        userVo.setBirthdayStr(date);

        if (userVo == null){
            throw new MyError("用户名或密码输入不正确");
        }
        return userVo;
    }

    @Override
    public UserVo editPersonInfo(UserEditBasicDto userEditBasicDto) throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("id",userEditBasicDto.getId());
        map.put("personName",userEditBasicDto.getPersonName());
        map.put("alias",userEditBasicDto.getAlias());
        map.put("birthday",userEditBasicDto.getBirthday());
        map.put("sex",userEditBasicDto.getSex());
        map.put("mail",userEditBasicDto.getMail());
        map.put("telephone",userEditBasicDto.getTelephone());

        int count = baseDao.update("com.lp.sqlMapper.user.User.editPersonInfo",map);

        int id = userEditBasicDto.getId();
        UserVo userVo = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getUserInfoById",id);

        return userVo;
    }

    @Override
    public UserVo editHeader(int id, MultipartFile multipartFile) throws MyError {
        String fileName = multipartFile.getOriginalFilename();
        fileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
        try {
            uploadFile(multipartFile.getBytes(), "D:/UAV_img/header" , fileName);
        } catch (Exception e) {
            throw new MyError("头像保存失败");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("header","header/"+fileName);
        int count = baseDao.update("com.lp.sqlMapper.user.User.editPersonInfo",map);


        UserVo userVo = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getUserInfoById",id);

        return userVo;
    }

    /**
     * 保存图片文件到指定目录
     *
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String file_path = filePath + "/" + fileName;
        FileOutputStream out = new FileOutputStream(file_path);
        out.write(file);
        out.flush();
        out.close();
    }
}
