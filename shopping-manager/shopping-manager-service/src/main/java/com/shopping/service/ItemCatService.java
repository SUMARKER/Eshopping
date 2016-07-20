package com.shopping.service;

import com.shopping.common.pojo.EUTreeNode;

import java.util.List;

/**
 * Created by Administrator on 2016/7/20.
 */
public interface ItemCatService {
    List<EUTreeNode> getCatList(long parentId);
}
