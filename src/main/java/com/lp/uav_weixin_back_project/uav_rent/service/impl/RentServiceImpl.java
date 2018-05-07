package com.lp.uav_weixin_back_project.uav_rent.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_rent.model.dto.RentProductDto;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentProductDetailVo;
import com.lp.uav_weixin_back_project.uav_rent.model.vo.RentProductVo;
import com.lp.uav_weixin_back_project.uav_rent.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<RentProductVo> getRentAllInfo() {
        List<RentProductVo> rentProductVoList = baseDao.getList("com.lp.sqlMapper.rent.RentProduct.getRentAllInfo",null);
        return rentProductVoList;
    }

    @Override
    public int insertRentInfo(Integer userId, RentProductDto rentProductDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("rentProductName",rentProductDto.getRentProductName());
        map.put("rentProductDescribe",rentProductDto.getRentProductDescribe());
        map.put("rentProductPrice",rentProductDto.getRentProductPrice());
        map.put("type",rentProductDto.getType());
        map.put("createTime",new Date());
        map.put("lastUpdateTime",new Date());
        map.put("id",0);
        int count = baseDao.insert("com.lp.sqlMapper.rent.RentProduct.insertRentInfo",map);
        if (count<=0){
            throw new MyError("保存失败，系统错误！");
        }
        int id = (int) map.get("id");
        return id;
    }

    @Override
    public int insertRentInfoPicture(Integer id, MultipartFile multipartFile) throws MyError {
        String fileName = multipartFile.getOriginalFilename();
        fileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
        try {
            uploadFile(multipartFile.getBytes(), "D:/UAV_img/product" , fileName);
        } catch (Exception e) {
            throw new MyError("图片保存失败");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("rentProductPicture","product/"+fileName);
        int count = baseDao.update("com.lp.sqlMapper.rent.RentProduct.insertRentInfoPicture",map);
        return count;
    }

    @Override
    public RentProductDetailVo getRentDetailInfo(Integer id) {
        RentProductDetailVo rentProductDetailVo = baseDao.getOneBySqlId("com.lp.sqlMapper.rent.RentProduct.getRentDetailInfo",id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (rentProductDetailVo.getCreateTime() != null && rentProductDetailVo.getCreateTime().equals("")) {
            rentProductDetailVo.setCreateTimeStr(format.format(rentProductDetailVo.getCreateTime()));
        }
        if (rentProductDetailVo.getLastUpdateTime() != null && rentProductDetailVo.getLastUpdateTime().equals("")) {
            rentProductDetailVo.setLastUpdateTimeStr(format.format(rentProductDetailVo.getLastUpdateTime()));
        }

        return rentProductDetailVo;
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
