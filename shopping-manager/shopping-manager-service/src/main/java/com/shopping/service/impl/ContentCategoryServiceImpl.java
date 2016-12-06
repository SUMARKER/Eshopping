package com.shopping.service.impl;

import com.shopping.common.pojo.EUTreeNode;
import com.shopping.common.pojo.EshoppingResult;
import com.shopping.mapper.TbContentCategoryMapper;
import com.shopping.pojo.TbContentCategory;
import com.shopping.pojo.TbContentCategoryExample;
import com.shopping.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EUTreeNode> getCategoryList(long parentId) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        for (TbContentCategory tbcontentCategory : list) {
            EUTreeNode node = new EUTreeNode();
            node.setId(tbcontentCategory.getId());
            node.setText(tbcontentCategory.getName());
            node.setState(tbcontentCategory.getIsParent() ? "closed" : "open");
            resultList.add(node);
        }
        return resultList;
    }

    @Override
    public EshoppingResult insertContentCategory(long parentId, String name) {
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setName(name);
        contentCategory.setIsParent(false);
        contentCategory.setStatus(1);
        contentCategory.setParentId(parentId);
        contentCategory.setSortOrder(1);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        contentCategoryMapper.insert(contentCategory);
        TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
        if (!parentCat.getIsParent()) {
            parentCat.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKey(parentCat);
        }
        return EshoppingResult.ok(contentCategory);
    }

    //删除叶子节点
    @Override
    public EshoppingResult deleteContentCategory(long parentId, long id) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);

        for (TbContentCategory tbcontentCategory : list) {
            System.out.println(tbcontentCategory);
            if (!tbcontentCategory.getIsParent()) {
                contentCategoryMapper.deleteByPrimaryKey(id);
            } else {


            }
        }
        return EshoppingResult.ok();
    }

}
