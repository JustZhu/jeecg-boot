package com.labor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.labor.entity.LaborCompJn;

import java.util.List;

/**
 * @Description: labor_comp_jn
 * @Author: jeecg-boot
 * @Date: 2022-11-08
 * @Version: V1.0
 */
public interface LaborCompJnMapper extends BaseMapper<LaborCompJn>
{
    List<LaborCompJn> queryGhListByGhbm(String parentId);


    int hasChild(String parentId);
}
