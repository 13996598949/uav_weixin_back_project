package com.lp.uav_weixin_back_project.user.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.user.model.dto.*;
import com.lp.uav_weixin_back_project.user.model.vo.AddressCallbackListVo;
import com.lp.uav_weixin_back_project.user.model.vo.AddressListVo;
import com.lp.uav_weixin_back_project.user.model.vo.UserVo;
import com.lp.uav_weixin_back_project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Override
    public Integer editLoginPassword(int id, EditPasswordDto passwordDto) throws MyError {
        // 获取原密码
        String oldPassword = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getLoginPasswordById",id);
        // 比较原密码
        if (!oldPassword.equals(passwordDto.getOldPassword())){
            throw new MyError("原密码输入不正确");
        }

        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("newPassword",passwordDto.getNewPassword());
        int count = baseDao.update("com.lp.sqlMapper.user.User.editLoginPassword",map);

        return count;
    }

    @Override
    public Integer editBuyPassword(int id, EditPasswordDto passwordDto) throws MyError {
        // 获取原密码
        String oldPassword = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getBuyPasswordById",id);
        // 比较原密码
        if (!oldPassword.equals(passwordDto.getOldPassword())){
            throw new MyError("原密码输入不正确");
        }

        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("newPassword",passwordDto.getNewPassword());
        int count = baseDao.update("com.lp.sqlMapper.user.User.editBuyPassword",map);
        return count;
    }

    @Override
    public List<AddressCallbackListVo> getAddressList(int userId) {
        List<AddressListVo> addressList = baseDao.getList("com.lp.sqlMapper.user.User.getAddressList",userId);
        List<AddressCallbackListVo> addressCallbackListVos = new ArrayList<>();
        if (addressList!=null && addressList.size()>0) {
            for (AddressListVo avo : addressList){
                AddressCallbackListVo bvo = new AddressCallbackListVo();
                bvo.setId(avo.getId());
                bvo.setName(avo.getReceiveName());
                bvo.setAddress(avo.getProvince() +" "+ avo.getCity() +" "+ avo.getCounty() +" "+ avo.getDistrictDetail());
                bvo.setTel(avo.getTelephone());
                addressCallbackListVos.add(bvo);
            }
        }

        return addressCallbackListVos;
    }

    @Override
    public int insertAddress(int userId, AddressDto addressDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("receiveName", addressDto.getReceiveName());
        map.put("telephone", addressDto.getTelephone());
        map.put("province", addressDto.getProvince());
        map.put("city", addressDto.getCity());
        map.put("county", addressDto.getCounty());
        map.put("districtDetail", addressDto.getDistrictDetail());
        map.put("postalCode", addressDto.getPostalCode());
        int count = baseDao.insert("com.lp.sqlMapper.user.User.insertAddress",map);
        if (count <= 0){
            throw new MyError("添加失败");
        }
        return count;
    }

    @Override
    public int editAddress(int id, AddressDto addressDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("receiveName", addressDto.getReceiveName());
        map.put("telephone", addressDto.getTelephone());
        map.put("province", addressDto.getProvince());
        map.put("city", addressDto.getCity());
        map.put("county", addressDto.getCounty());
        map.put("districtDetail", addressDto.getDistrictDetail());
        map.put("postalCode", addressDto.getPostalCode());
        int count = baseDao.update("com.lp.sqlMapper.user.User.editAddress",map);
        if (count <= 0){
            throw new MyError("保存失败");
        }
        return count;
    }

    @Override
    public AddressListVo getAddressById(int id) {
        AddressListVo addressListVos = baseDao.getOneBySqlId("com.lp.sqlMapper.user.User.getAddressListById",id);
        return addressListVos;
    }

    @Override
    public int deleteAddress(int id) {
        int count = baseDao.delete("com.lp.sqlMapper.user.User.deleteAddress",id);
        return count;
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
