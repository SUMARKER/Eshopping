package com.shopping.controller;

import com.shopping.common.pojo.EUTreeNode;
import com.shopping.common.pojo.EshoppingResult;
import com.shopping.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
        return list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public EshoppingResult createContentCategory(Long parentId, String name) {
        EshoppingResult result = contentCategoryService.insertContentCategory(parentId, name);
        return result;
    }
    //删除子节点
    @RequestMapping("/delete")
    @ResponseBody
    public EshoppingResult deleteContentCategory(@RequestParam(value = "parentId", defaultValue = "0")Long parentId,Long id){
        EshoppingResult result = contentCategoryService.deleteContentCategory(parentId,id);
        return result;
    }
}
