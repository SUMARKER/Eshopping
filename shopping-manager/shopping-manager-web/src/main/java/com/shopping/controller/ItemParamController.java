package com.shopping.controller;

import com.shopping.common.pojo.EshoppingResult;
import com.shopping.pojo.TbItemParam;
import com.shopping.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/10/27.
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public EshoppingResult getItemParamByCid(@PathVariable Long itemCatId) {
        EshoppingResult result = itemParamService.getItemParamByCid(itemCatId);
        return result;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public EshoppingResult insertItemParam(@PathVariable Long cid, String paramData) {
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        EshoppingResult result = itemParamService.insertItemParam(itemParam);
        return result;
    }
}
