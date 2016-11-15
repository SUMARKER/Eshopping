package com.shopping.rest.controller;

import com.shopping.common.utils.JsonUtils;
import com.shopping.rest.pojo.CatResult;
import com.shopping.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/11/15.
 */
@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    //    @RequestMapping(value = "/itemcat/list", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
//    @ResponseBody
//    public String getItemCatList(String callback) {
//        CatResult catResult = itemCatService.getItemCatList();
//        String json = JsonUtils.objectToJson(catResult);
//        String result = callback + "(" + json + ");";
//        return result;
//    }

    //Spring 4.1.x以后的版本
    @RequestMapping(value = "/itemcat/list", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public Object getItemCatList(String callback) {
        CatResult catResult = itemCatService.getItemCatList();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
