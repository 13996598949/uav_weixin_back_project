package com.lp.uav_weixin_back_project.uav_sale.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_sale.model.dto.SaleProductDto;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.SaleProductVo;
import com.lp.uav_weixin_back_project.uav_sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<SaleProductVo> getSaleAllInfo() {
        List<SaleProductVo> saleProductVoList = baseDao.getList("com.lp.sqlMapper.sale.SaleProduct.getSaleAllInfo",null);
        return saleProductVoList;
    }

    @Override
    public int insertSaleInfo(Integer userId, SaleProductDto saleProductDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("saleProductName",saleProductDto.getSaleProductName());
        map.put("saleProductDescribe",saleProductDto.getSaleProductDescribe());
        map.put("saleProductPrice",saleProductDto.getSaleProductPrice());
        map.put("type",saleProductDto.getType());
        map.put("createTime",new Date());
        map.put("lastUpdateTime",new Date());
        map.put("id",0);
        int count = baseDao.insert("com.lp.sqlMapper.sale.SaleProduct.insertSaleInfo",map);
        if (count<=0){
            throw new MyError("保存失败，系统错误！");
        }
        int id = (int) map.get("id");
        return id;
    }

    @Override
    public int insertSaleInfoPicture(Integer id, MultipartFile multipartFile) throws MyError {
        String fileName = multipartFile.getOriginalFilename();
        fileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
        try {
            uploadFile(multipartFile.getBytes(), "D:/UAV_img/product" , fileName);
        } catch (Exception e) {
            throw new MyError("图片保存失败");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("saleProductPicture","product/"+fileName);
        int count = baseDao.update("com.lp.sqlMapper.sale.SaleProduct.insertSaleInfoPicture",map);
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
