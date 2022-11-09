package org.jeecg.modules.system.rule;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.handler.IFillRuleHandler;
import org.jeecg.modules.online.cgform.mapper.OnlCgformHeadMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author scott
 * @Date 2019/12/9 11:33
 * @Description: 机构编码生成规则
 */
public class SortNumRule implements IFillRuleHandler
{
    @Autowired
    OnlCgformHeadMapper mapper;
    @Override
    public Object execute(JSONObject params, JSONObject formData)
    {

        int sortNum = 5;
        // 根据formData的值的不同，生成不同的订单号
        String tableName = formData.getString("tableName");
        if (!StringUtils.isEmpty(tableName))
        {
            String sql = "select ifnull（max(sort_num）,0)+5 from " + tableName + " where 1=1";
            List<Map<String, Object>> maps = mapper.queryList(sql);
            System.out.println("maps = " + maps);

        }
        return sortNum;

    }
}
