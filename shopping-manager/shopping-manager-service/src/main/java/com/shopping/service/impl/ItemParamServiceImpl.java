package com.shopping.service.impl;

import com.shopping.common.pojo.EshoppingResult;
import com.shopping.mapper.TbItemMapper;
import com.shopping.mapper.TbItemParamMapper;
import com.shopping.pojo.TbItemParam;
import com.shopping.pojo.TbItemParamExample;
import com.shopping.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{
    @Autowired
    private TbItemParamMapper itemParamMapper;
    @Override
    public EshoppingResult getItemParamByCid(long cid) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria=example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam>list=itemParamMapper.selectByExampleWithBLOBs(example);
        if (list !=null&&list.size()>0){
            return EshoppingResult.ok(list.get(0));
        }

        return EshoppingResult.ok();
    }

    @Override
    public EshoppingResult insertItemParam(TbItemParam itemParam) {
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        itemParamMapper.insert(itemParam);
        return EshoppingResult.ok();
    }
}
