package com.shopping.service.impl;

import java.util.Date;
import java.util.List;

import com.shopping.common.pojo.EshoppingResult;
import com.shopping.common.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.common.pojo.EUDataGridResult;
import com.shopping.mapper.TbItemMapper;
import com.shopping.pojo.TbItem;
import com.shopping.pojo.TbItemExample;
import com.shopping.pojo.TbItemExample.Criteria;
import com.shopping.service.ItemService;

/**
 * Created by Administrator on 2016/7/15.
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		// TbItem tbItem = itemMapper.selectByPrimaryKey(ItemId);
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);

		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		EUDataGridResult result = new EUDataGridResult();
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

	@Override
	public EshoppingResult createItem(TbItem item) {
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.insert(item);
		return EshoppingResult.ok();
	}

}
