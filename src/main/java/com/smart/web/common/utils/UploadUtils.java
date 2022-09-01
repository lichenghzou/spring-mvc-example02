package com.smart.web.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.druid.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class UploadUtils {
    public static final String PREFIX_IMG = "IMG_";
    public static final String IMG_PATH = "\\static\\img";
    public static final String ROOT_PATH="E:\\qianfeng\\code\\code_3阶段\\Day08_spring-mvc\\spring-mvc-example02\\src\\main\\webapp";


    /**
     * 保存到本地
     * 返回图片回显的路径  保存到数据库的路径
     * E:\qianfeng\code\code_3阶段\Day08_spring-mvc\spring-mvc-example02\src\main\webapp\static\img\20220831\IMG_1111.png
     *
     * @return
     */
    public static String save(MultipartFile multipartFile) throws IOException {
        //1.文件重命名  -- 传递原名
        String fileNewName = getFileNewName(multipartFile.getOriginalFilename());
        //2.设置图片保存路径
        String savePath = IMG_PATH +"\\"+ DateUtil.format(new Date(),"yyyyMMdd")+"\\"+fileNewName;
        //3.根据全路径上传图片
        //  3.1 获取文件
        File file = new File(ROOT_PATH + savePath);
        //  3.2创建目录
        if (!file.exists()){
            file.mkdirs();
        }
        //  3.3文件上传
        multipartFile.transferTo(file);//封装文件上传方法
        //4.返回保存路径(返显)
        return savePath;
    }
    /**
     * 规则+ 原生图片的后缀
     * IMG_  + 时间戳+随机数+ 后缀名
     */
    /**
     * 对文件重命名
     * 保存图片到本地
     * xxxx.jpg
     */
    private static String getFileNewName(String oldFileName) {
        //IMG_2022xxxx1343.png
        return String.format("%s%s%s%s", PREFIX_IMG, DateUtil.format(new Date(), "yyyyMMdd"), RandomUtil.randomNumbers(4), oldFileName.substring(oldFileName.lastIndexOf(".")));
    }


    //测试
    public static void main(String[] args) {
        String fileNewName = getFileNewName("11111.png");
        System.out.println(fileNewName);
    }
}
