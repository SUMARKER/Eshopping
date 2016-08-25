package com.shopping.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by Administrator on 2016/8/25.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
