package com.shopping.service;

import com.shopping.common.pojo.EshoppingResult;
import com.shopping.pojo.TbItemParam;

/**
 * Created by Administrator on 2016/10/27.
 */
public interface ItemParamService {
    EshoppingResult getItemParamByCid(long cid);
    EshoppingResult insertItemParam(TbItemParam itemParam);
}
