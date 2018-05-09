package com.lp.uav_weixin_back_project.uav_rent.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectRentVo;
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
    public List<RentProductVo> getRentAllInfo(Integer userId) {
        List<RentProductVo> rentProductVoList = baseDao.getList("com.lp.sqlMapper.rent.RentProduct.getRentAllInfo",null);
        if (userId!=null && userId!=0){
            List<CollectRentVo> collectRentVos = baseDao.getList("com.lp.sqlMapper.collect.CollectRent.getCollectRent",userId);
            if (collectRentVos!=null && collectRentVos.size()>0){
                if (rentProductVoList!=null && rentProductVoList.size()>0){
                    for (RentProductVo productVo : rentProductVoList){
                        for (CollectRentVo collectRentVo : collectRentVos){
                            if (productVo.getId().equals(collectRentVo.getId())){
                                productVo.setCollectFlag(true);
                            }
                        }
                    }
                }
            }
        }
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
        MultipartFile m = multipartFile;
        if (m!=null) {
            String fileName = multipartFile.getOriginalFilename();
            fileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
            try {
                uploadFile(multipartFile.getBytes(), "D:/UAV_img/product", fileName);
            } catch (Exception e) {
                throw new MyError("图片保存失败");
            }
            Map<String, Object> map = new HashMap<>();
            map.put("id", id);
            map.put("rentProductPicture", "product/" + fileName);
            int count = baseDao.update("com.lp.sqlMapper.rent.RentProduct.insertRentInfoPicture", map);
            return count;
        }else {
            return 0;
        }
    }

    @Override
    public RentProductDetailVo getRentDetailInfo(Integer id, Integer userId) {
        RentProductDetailVo rentProductDetailVo = baseDao.getOneBySqlId("com.lp.sqlMapper.rent.RentProduct.getRentDetailInfo",id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (rentProductDetailVo.getCreateTime() != null && !rentProductDetailVo.getCreateTime().equals("")) {
            rentProductDetailVo.setCreateTimeStr(format.format(rentProductDetailVo.getCreateTime()));
        }
        if (rentProductDetailVo.getLastUpdateTime() != null && !rentProductDetailVo.getLastUpdateTime().equals("")) {
            rentProductDetailVo.setLastUpdateTimeStr(format.format(rentProductDetailVo.getLastUpdateTime()));
        }

        if (userId!=null && userId!=0){
            List<CollectRentVo> collectRentVos = baseDao.getList("com.lp.sqlMapper.collect.CollectRent.getCollectRent",userId);
            if (collectRentVos!=null && collectRentVos.size()>0){
                if (rentProductDetailVo!=null){
                    for (CollectRentVo collectRentVo : collectRentVos){
                        if (rentProductDetailVo.getId().equals(collectRentVo.getId())){
                            rentProductDetailVo.setCollectFlag(true);
                        }
                    }
                }
            }
        }

        return rentProductDetailVo;
    }

    @Override
    public List<RentProductVo> getMyPublishRent(Integer userId) {
        List<RentProductVo> rentProductVoList = baseDao.getList("com.lp.sqlMapper.rent.RentProduct.getMyPublishRent",userId);
        return rentProductVoList;
    }

    @Override
    public int editRentInfo(Integer id, RentProductDto rentProductDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("rentProductName",rentProductDto.getRentProductName());
        map.put("rentProductDescribe",rentProductDto.getRentProductDescribe());
        map.put("rentProductPrice",rentProductDto.getRentProductPrice());
        map.put("type",rentProductDto.getType());
        map.put("lastUpdateTime",new Date());

        int count = baseDao.update("com.lp.sqlMapper.rent.RentProduct.editRentInfo",map);
        if (count<=0){
            throw new MyError("保存失败，系统错误！");
        }
        return count;
    }

    @Override
    public int deleteMyPublishRent(Integer id) throws MyError {
        int count = baseDao.delete("com.lp.sqlMapper.rent.RentProduct.deleteMyPublishRent",id);
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