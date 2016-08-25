package com.shopping.service.impl;

import com.shopping.common.utils.IDUtils;
import com.shopping.service.PicetureService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
//import java.util.UUID;

/**
 * Created by Administrator on 2016/8/25.
 */
@Service
public class PictureServiceImpl implements PicetureService {
    @Override
    public Map uploadPicture(MultipartFile uplodaFile) {
        //取出文件原来的名字，为了获取其扩展名
        String oldName = uplodaFile.getOriginalFilename();
        //生成新的文件名
        //UUID.randomUUID();
        String newName =IDUtils.genImageName();
        return null;
    }
}
