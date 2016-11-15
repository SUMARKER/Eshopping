package com.shopping.service.impl;

import com.shopping.common.utils.JsonUtils;
import com.shopping.mapper.TbItemParamItemMapper;
import com.shopping.pojo.TbItemParamItem;
import com.shopping.pojo.TbItemParamItemExample;
import com.shopping.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/14.
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Override
    public String getItemParamByItemId(Long itemId) {
        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
        if (list == null || list.size() == 0) {
            return "";
        }
        TbItemParamItem itemParamItem = list.get(0);
        String paramData = itemParamItem.getParamData();
        List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<table cellpadding=\"0\" width=\"100%\" border=\"0\"class=\"Ptable\">\n");
        stringBuffer.append("    <tbody>\n");
        for (Map m1 : jsonList) {
            stringBuffer.append("        <tr>\n");
            stringBuffer.append("            <th class=\"tdTitle\" colspan=\"2\">" + m1.get("group") + "</th>\n");
            stringBuffer.append("        </tr>\n");
            List<Map> list2 = (List<Map>) m1.get("params");
            for (Map m2 : list2) {
                stringBuffer.append("        <tr>\n");
                stringBuffer.append("            <td class=\"tdTitle\">" + m2.get("k") + "</td>\n");
                stringBuffer.append("            <td>" + m2.get("v") + "</td>\n");
                stringBuffer.append("        </tr>\n");
            }
        }
        stringBuffer.append("    </tbody>\n");
        stringBuffer.append("</table>");
        return stringBuffer.toString();
    }
}
