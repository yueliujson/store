package com.easy.controller;

import com.easy.bean.ProductImg;
import com.easy.service.ProductImgServiceDao;
import com.easy.utils.ResultData;
import com.easy.utils.Sys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class ProductImgController {
    @Autowired
    ProductImgServiceDao productImgServiceDao;

    @GetMapping("/productImg/{id}")
    public ResultData get(@PathVariable int id) {
        ProductImg productImg = productImgServiceDao.get(id);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", productImg);
        return rd;
    }
    @PostMapping("/productImg")
    public ResultData save(@RequestBody ProductImg[] productImg){
        int save = productImgServiceDao.save(productImg);
        ResultData rd;
        if (save > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }
    @PutMapping("/productImg")
    public ResultData edit(@RequestBody ProductImg productImg){
        int edit = productImgServiceDao.edit(productImg);
        ResultData rd;
        if (edit > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }
    @DeleteMapping("/productImg/{id}")
    public ResultData delete(@PathVariable int id){
        int delete = productImgServiceDao.delete(id);
        ResultData rd;
        if (delete > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }
//上传图片
    @PostMapping("/productImg/img")
    public ResultData save(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        ResultData rd ;
        if (file.isEmpty()){
            rd=new ResultData(202,"fail");
        }else {
            //获取文件名称
            String filename = file.getOriginalFilename();
            //获取文件后缀名
            String suffixName = filename.substring(filename.indexOf("."));
            //随机生产文件名称
            filename= UUID.randomUUID()+suffixName;
            //设置文件路径
            String filepath=Sys.IMAGES_PATH;
            //上传
            File dest=new File(filepath,filename);
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
            //判断路径是否存在
            if (!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                return new ResultData(202,"fail");
            }
            String reName=basePath+"static/img/"+filename;
            rd=new ResultData(200,"success");
            rd.put("data",reName);
        }
        return rd;
    }

}
