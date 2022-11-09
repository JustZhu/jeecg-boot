package com.labor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.labor.entity.LaborCompJn;

import java.util.List;

/**
 * @Description: labor_comp_jn
 * @Author: jeecg-boot
 * @Date: 2022-11-08
 * @Version: V1.0
 */
public interface ILaborCompJnService extends IService<LaborCompJn>
{

    /**
     * 查询工会信息
     *
     * @param parentId
     * @return
     */

    public List<LaborCompJn> queryGhListByGhbm(String parentId);

    public boolean hasChild(String parentId);
}
