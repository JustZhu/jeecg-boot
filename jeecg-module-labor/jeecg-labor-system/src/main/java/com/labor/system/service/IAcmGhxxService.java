package com.labor.system.service;

import com.labor.system.entity.AcmGhxx;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.common.exception.JeecgBootException;
import org.jeecg.common.system.vo.SelectTreeModel;

import java.util.List;

/**
 * @Description: 工会管理
 * @Author: jeecg-boot
 * @Date: 2022-11-08
 * @Version: V1.0
 */
public interface IAcmGhxxService extends IService<AcmGhxx>
{

    /**
     * 根节点父ID的值
     */
    public static final String ROOT_PID_VALUE = "0";

    /**
     * 树节点有子节点状态值
     */
    public static final String HASCHILD = "1";

    /**
     * 树节点无子节点状态值
     */
    public static final String NOCHILD = "0";

    /**
     * 新增节点
     *
     * @param acmGhxx
     */
    void addAcmGhxx(AcmGhxx acmGhxx);

    /**
     * 修改节点
     *
     * @param acmGhxx
     * @throws JeecgBootException
     */
    void updateAcmGhxx(AcmGhxx acmGhxx) throws JeecgBootException;

    /**
     * 删除节点
     *
     * @param id
     * @throws JeecgBootException
     */
    void deleteAcmGhxx(String id) throws JeecgBootException;

    /**
     * 查询所有数据，无分页
     *
     * @param queryWrapper
     * @return List<AcmGhxx>
     */
    List<AcmGhxx> queryTreeListNoPage(QueryWrapper<AcmGhxx> queryWrapper);

    /**
     * 【vue3专用】根据父级编码加载分类字典的数据
     *
     * @param parentCode
     * @return
     */
    List<SelectTreeModel> queryListByCode(String parentCode);

    /**
     * 【vue3专用】根据pid查询子节点集合
     *
     * @param pid
     * @return
     */
    List<SelectTreeModel> queryListByPid(String pid);

}