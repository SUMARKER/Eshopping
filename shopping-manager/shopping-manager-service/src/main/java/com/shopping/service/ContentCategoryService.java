package com.shopping.service;

import com.shopping.common.pojo.EUTreeNode;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
public interface ContentCategoryService {
    List<EUTreeNode>getCategoryList(long parentId);
}
