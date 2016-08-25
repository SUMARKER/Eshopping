package com.shopping.controller;

import com.shopping.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by Administrator on 2016/8/25.
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @ResponseBody
    @RequestMapping("/pic/upload")
    public Map pictureUpload(MultipartFile uploadFile){
        Map result=pictureService.uploadPicture(uploadFile);
        return result;
    }
}
