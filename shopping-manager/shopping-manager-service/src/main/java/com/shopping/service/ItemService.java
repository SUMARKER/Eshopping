package com.shopping.service;

import com.shopping.common.pojo.EshoppingResult;
import org.springframework.stereotype.Repository;

import com.shopping.common.pojo.EUDataGridResult;
import com.shopping.pojo.TbItem;

/**
 * Created by Administrator on 2016/7/15.
 */
@Repository
public interface ItemService {
	TbItem getItemById(long ItemId);

	EUDataGridResult getItemList(int total, int rows);

	EshoppingResult createItem(TbItem item,String desc,String itemParam) throws Exception;
}
