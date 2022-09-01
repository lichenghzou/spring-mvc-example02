package com.smart.web.controller;

import com.smart.web.common.result.ResponseResult;
import com.smart.web.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/image")
    public ResponseResult<String> uploadImage(@RequestParam MultipartFile multipartFile){

        return ResponseResult.success(uploadService.uploadImage(multipartFile));
    }
}
