package com.labor.system.mapper;

import com.labor.system.entity.AcmGhxx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.common.system.vo.SelectTreeModel;

import java.util.List;
import java.util.Map;

/**
 * @Description: 工会管理
 * @Author: jeecg-boot
 * @Date: 2022-11-08
 * @Version: V1.0
 */
public interface AcmGhxxMapper extends BaseMapper<AcmGhxx>
{

    /**
     * 编辑节点状态
     *
     * @param id
     * @param status
     */
    void updateTreeNodeStatus(@Param("id") String id, @Param("status") String status);

    /**
     * 【vue3专用】根据父级ID查询树节点数据
     *
     * @param pid
     * @param query
     * @return
     */
    List<SelectTreeModel> queryListByPid(@Param("pid") String pid, @Param("query") Map<String, String> query);

}
