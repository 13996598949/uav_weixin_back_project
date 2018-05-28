package com.lp.uav_weixin_back_project.uav_sale.service.impl;

import com.lp.uav_weixin_back_project.db.BaseDao;
import com.lp.uav_weixin_back_project.exception.MyError;
import com.lp.uav_weixin_back_project.uav_collect.model.vo.CollectSaleVo;
import com.lp.uav_weixin_back_project.uav_sale.model.dto.SaleMessageDto;
import com.lp.uav_weixin_back_project.uav_sale.model.dto.SaleProductDto;
import com.lp.uav_weixin_back_project.uav_sale.model.dto.SaleRecordNumDto;
import com.lp.uav_weixin_back_project.uav_sale.model.dto.SaleReplyDto;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.MyMessageSaleVo;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.SaleMessageVo;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.SaleProductDetailVo;
import com.lp.uav_weixin_back_project.uav_sale.model.vo.SaleProductVo;
import com.lp.uav_weixin_back_project.uav_sale.service.SaleService;
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
public class SaleServiceImpl implements SaleService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<SaleProductVo> getSaleAllInfo(Integer userId, String saleName) {
        if (saleName!=null && !saleName.equals("")){
            saleName = saleName.replaceAll("'","");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("saleName",saleName);
        List<SaleProductVo> saleProductVoList = baseDao.getList("com.lp.sqlMapper.sale.SaleProduct.getSaleAllInfo",map);
        if (userId!=null && userId!=0){
            List<CollectSaleVo> collectSaleVos = baseDao.getList("com.lp.sqlMapper.collect.CollectSale.getCollectSale",userId);
            if (collectSaleVos!=null && collectSaleVos.size()>0){
                if (saleProductVoList!=null && saleProductVoList.size()>0){
                    for (SaleProductVo productVo : saleProductVoList){
                        for (CollectSaleVo collectSaleVo : collectSaleVos){
                            if (productVo.getId().equals(collectSaleVo.getId())){
                                productVo.setCollectFlag(true);
                            }
                        }
                    }
                }
            }
        }
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
        MultipartFile m = multipartFile;
        if (m!=null) {
            String fileName = multipartFile.getOriginalFilename();
            fileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
            try {
                uploadFile(multipartFile.getBytes(), "C:/UAV_img/product", fileName);
            } catch (Exception e) {
                throw new MyError("图片保存失败");
            }
            Map<String, Object> map = new HashMap<>();
            map.put("id", id);
            map.put("saleProductPicture", "product/" + fileName);
            int count = baseDao.update("com.lp.sqlMapper.sale.SaleProduct.insertSaleInfoPicture", map);
            return count;
        }else{
            return 0;
        }
    }

    @Override
    public SaleProductDetailVo getSaleDetailInfo(Integer id, Integer userId) {
        SaleProductDetailVo saleProductDetailVo = baseDao.getOneBySqlId("com.lp.sqlMapper.sale.SaleProduct.getSaleDetailInfo",id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (saleProductDetailVo!=null) {
            if (saleProductDetailVo.getCreateTime() != null && !saleProductDetailVo.getCreateTime().equals("")) {
                saleProductDetailVo.setCreateTimeStr(format.format(saleProductDetailVo.getCreateTime()));
            }
            if (saleProductDetailVo.getLastUpdateTime() != null && !saleProductDetailVo.getLastUpdateTime().equals("")) {
                saleProductDetailVo.setLastUpdateTimeStr(format.format(saleProductDetailVo.getLastUpdateTime()));
            }
        }

        if (userId!=null && userId!=0){
            List<CollectSaleVo> collectSaleVos = baseDao.getList("com.lp.sqlMapper.collect.CollectSale.getCollectSale",userId);
            if (collectSaleVos!=null && collectSaleVos.size()>0){
                if (saleProductDetailVo!=null){
                    for (CollectSaleVo collectSaleVo : collectSaleVos){
                        if (saleProductDetailVo.getId().equals(collectSaleVo.getId())){
                            saleProductDetailVo.setCollectFlag(true);
                        }
                    }
                }
            }
        }

        return saleProductDetailVo;
    }

    @Override
    public List<SaleProductVo> getMyPublishSale(Integer userId) {
        List<SaleProductVo> saleProductVoList = baseDao.getList("com.lp.sqlMapper.sale.SaleProduct.getMyPublishSale",userId);
        return saleProductVoList;
    }

    @Override
    public int editSaleInfo(Integer id, SaleProductDto saleProductDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("saleProductName",saleProductDto.getSaleProductName());
        map.put("saleProductDescribe",saleProductDto.getSaleProductDescribe());
        map.put("saleProductPrice",saleProductDto.getSaleProductPrice());
        map.put("type",saleProductDto.getType());
        map.put("lastUpdateTime",new Date());

        int count = baseDao.update("com.lp.sqlMapper.sale.SaleProduct.editSaleInfo",map);
        if (count<=0){
            throw new MyError("保存失败，系统错误！");
        }
        return count;
    }

    @Override
    public int deleteMyPublishSale(Integer id) {
        int count = baseDao.delete("com.lp.sqlMapper.sale.SaleProduct.deleteMyPublishSale",id);
        return count;
    }

    @Override
    public SaleProductDetailVo getSaleSimpleInfo(Integer id) {
        SaleProductDetailVo saleProductSimpleVo = baseDao.getOneBySqlId("com.lp.sqlMapper.sale.SaleProduct.getSaleSimpleInfo",id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (saleProductSimpleVo!=null) {
            if (saleProductSimpleVo.getCreateTime() != null && !saleProductSimpleVo.getCreateTime().equals("")) {
                saleProductSimpleVo.setCreateTimeStr(format.format(saleProductSimpleVo.getCreateTime()));
            }
            if (saleProductSimpleVo.getLastUpdateTime() != null && !saleProductSimpleVo.getLastUpdateTime().equals("")) {
                saleProductSimpleVo.setLastUpdateTimeStr(format.format(saleProductSimpleVo.getLastUpdateTime()));
            }
        }
        return saleProductSimpleVo;
    }

    @Override
    public Integer recordSaleNum(SaleRecordNumDto saleRecordNumDto) throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("productId",saleRecordNumDto.getId());
        map.put("userId",saleRecordNumDto.getUserId());

        // 记录商品浏览量
        int count = baseDao.update("com.lp.sqlMapper.sale.SaleProduct.recordSaleNum", map);

        if (saleRecordNumDto.getUserId()!=null && !saleRecordNumDto.getUserId().equals("")) {
            // 记录用户浏览商品类别数
            if (saleRecordNumDto.getType() != null && !saleRecordNumDto.getType().equals("")) {
                if (saleRecordNumDto.getType() == 0) {
                    // 消费级
                    baseDao.update("com.lp.sqlMapper.user.User.recordConsumerNum", map);
                } else if (saleRecordNumDto.getType() == 1) {
                    // 专业级
                    baseDao.update("com.lp.sqlMapper.user.User.recordProfessionalNum", map);
                }
            }
        }

        return count;
    }

    @Override
    public int insertSaleMessage(SaleMessageDto messageDto) throws MyError {
        Map<String,Object> map = new HashMap<>();
        map.put("productId",messageDto.getProductId());
        map.put("personId",messageDto.getPersonId());
        map.put("message",messageDto.getMessage());
        map.put("createTime",new Date());

        int count = baseDao.insert("com.lp.sqlMapper.sale.SaleProduct.insertSaleMessage",map);
        if (count<=0){
            throw new MyError("留言失败!");
        }

        return count;
    }

    @Override
    public List<SaleMessageVo> getSaleMessage(Integer productId) {
        List<SaleMessageVo> saleMessage = baseDao.getList("com.lp.sqlMapper.sale.SaleProduct.getSaleMessage",productId);
        if (saleMessage!=null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (SaleMessageVo vo:saleMessage){
                if (vo.getMessageTime()!=null){
                    String messageTime = format.format(vo.getMessageTime());
                    vo.setMessageTimeStr(messageTime);
                }
                if (vo.getReplyTime()!=null){
                    String replyTime = format.format(vo.getReplyTime());
                    vo.setReplyTimeStr(replyTime);
                }
            }
        }
        return saleMessage;
    }

    @Override
    public List<MyMessageSaleVo> getMyMessageSaleInfo(Integer userId) {
        List<MyMessageSaleVo> myMessageSaleVos = baseDao.getList("com.lp.sqlMapper.sale.SaleProduct.getMyMessageSaleInfo",userId);
        return myMessageSaleVos;
    }

    @Override
    public int replySaleMessage(SaleReplyDto saleReplyDto) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",saleReplyDto.getMessageId());
        map.put("replyPersonId",saleReplyDto.getReplyPersonId());
        map.put("replyMessage",saleReplyDto.getReplyMessage());
        map.put("replyTime",new Date());
        int count = baseDao.update("com.lp.sqlMapper.sale.SaleProduct.replySaleMessage",map);
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
