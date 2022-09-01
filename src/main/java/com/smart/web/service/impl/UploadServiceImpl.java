package com.smart.web.service.impl;

import com.smart.web.common.ex.ServiceException;
import com.smart.web.common.result.ResponseCode;
import com.smart.web.common.utils.UploadUtils;
import com.smart.web.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {
    /**
     * 保存图片操作
     *  图片防止覆盖
     * @param multipartFile
     * @return
     */
    @Override
    public String uploadImage(MultipartFile multipartFile) {
        //封装文件上传工具类
        try {
            return UploadUtils.save(multipartFile);
        } catch (IOException e) {
            throw new ServiceException(ResponseCode.FILE_UPLOAD_ERROR);
        }
    }
}
