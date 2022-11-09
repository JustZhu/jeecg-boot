package com.labor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.labor.entity.LaborCompJn;
import com.labor.mapper.LaborCompJnMapper;
import com.labor.service.ILaborCompJnService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: labor_comp_jn
 * @Author: jeecg-boot
 * @Date: 2022-11-08
 * @Version: V1.0
 */
@Service
public class LaborCompJnServiceImpl extends ServiceImpl<LaborCompJnMapper, LaborCompJn> implements ILaborCompJnService
{


    public List<LaborCompJn> queryGhListByGhbm(String parentId)
    {


        return this.baseMapper.queryGhListByGhbm(parentId);
    }

    public boolean hasChild(String parentId)
    {
        return this.baseMapper.hasChild(parentId) > 0;
    }
}
