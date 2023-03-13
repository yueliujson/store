package com.easy.service.impl;

import com.easy.bean.ProductImg;
import com.easy.dao.ProductImgDao;
import com.easy.service.ProductImgServiceDao;
import com.easy.utils.Sys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductImgService implements ProductImgServiceDao {
    @Autowired
    ProductImgDao productImgDao;

    @Override
    public ProductImg get(int id) {
        ProductImg productImg = productImgDao.get(id);
//        if (productImg != null) {
//            readImg(productImg);
//        }
        return productImg;
    }

    @Override
    public List<ProductImg> list(ProductImg item) {
        List<ProductImg> list = productImgDao.list(item);
//        if (list != null) {
//            for (ProductImg productImg : list) {
//                readImg(productImg);
//            }
//        }
        return null;
    }


    /**
     * 读取图片地址,将图片读取,并写入字符串
     */
    private void readImg(ProductImg productImg) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            String imgUrl = productImg.getImgUrl();
            File file = new File(imgUrl);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            byte[] bytes = new byte[1024];
            StringBuilder br = new StringBuilder();
            while (bis.read(bytes) != -1) {
                br.append(Arrays.toString(bytes));
            }
            productImg.setImgUrl(br.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Transactional
    @Override
    public int delete(int id) {
        ProductImg productImg = get(id);
        if (productImg != null) {
            int delete = productImgDao.delete(id);
            String imgUrl = productImg.getImgUrl();
            File file = new File(Sys.IMAGES_PATH + imgUrl);
            file.delete();
            return delete;
        }else {
            return 0;
        }
    }

    @Override
    public int edit(ProductImg item) {
        return 0;
    }

    @Override
    public int save(ProductImg item) {
        if (item != null) {
            String imgUrl = item.getImgUrl();
            int index = imgUrl.indexOf("img");
            String substring = imgUrl.substring(index + 7);
            item.setImgUrl(substring);
        }
        int save = productImgDao.save(item);
        return save;
    }

}
