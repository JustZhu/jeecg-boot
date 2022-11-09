package com.labor.system.service.impl;

import com.labor.system.entity.AcmGhxx;
import com.labor.system.mapper.AcmGhxxMapper;
import com.labor.system.service.IAcmGhxxService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.common.exception.JeecgBootException;
import org.jeecg.common.system.vo.SelectTreeModel;
import org.jeecg.common.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 工会管理
 * @Author: jeecg-boot
 * @Date: 2022-11-08
 * @Version: V1.0
 */
@Service
public class AcmGhxxServiceImpl extends ServiceImpl<AcmGhxxMapper, AcmGhxx> implements IAcmGhxxService
{

    @Override
    public void addAcmGhxx(AcmGhxx acmGhxx)
    {
        //新增时设置hasChild为0
        acmGhxx.setHasChild(IAcmGhxxService.NOCHILD);
        if (oConvertUtils.isEmpty(acmGhxx.getPid()))
        {
            acmGhxx.setPid(IAcmGhxxService.ROOT_PID_VALUE);
        } else
        {
            //如果当前节点父ID不为空 则设置父节点的hasChildren 为1
            AcmGhxx parent = baseMapper.selectById(acmGhxx.getPid());
            if (parent != null && !"1".equals(parent.getHasChild()))
            {
                parent.setHasChild("1");
                baseMapper.updateById(parent);
            }
        }
        baseMapper.insert(acmGhxx);
    }

    @Override
    public void updateAcmGhxx(AcmGhxx acmGhxx)
    {
        AcmGhxx entity = this.getById(acmGhxx.getId());
        if (entity == null)
        {
            throw new JeecgBootException("未找到对应实体");
        }
        String old_pid = entity.getPid();
        String new_pid = acmGhxx.getPid();
        if (!old_pid.equals(new_pid))
        {
            updateOldParentNode(old_pid);
            if (oConvertUtils.isEmpty(new_pid))
            {
                acmGhxx.setPid(IAcmGhxxService.ROOT_PID_VALUE);
            }
            if (!IAcmGhxxService.ROOT_PID_VALUE.equals(acmGhxx.getPid()))
            {
                baseMapper.updateTreeNodeStatus(acmGhxx.getPid(), IAcmGhxxService.HASCHILD);
            }
        }
        baseMapper.updateById(acmGhxx);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAcmGhxx(String id) throws JeecgBootException
    {
        //查询选中节点下所有子节点一并删除
        id = this.queryTreeChildIds(id);
        if (id.indexOf(",") > 0)
        {
            StringBuffer sb = new StringBuffer();
            String[] idArr = id.split(",");
            for (String idVal : idArr)
            {
                if (idVal != null)
                {
                    AcmGhxx acmGhxx = this.getById(idVal);
                    String pidVal = acmGhxx.getPid();
                    //查询此节点上一级是否还有其他子节点
                    List<AcmGhxx> dataList = baseMapper.selectList(new QueryWrapper<AcmGhxx>().eq("pid", pidVal).notIn("id", Arrays.asList(idArr)));
                    boolean flag = (dataList == null || dataList.size() == 0) && !Arrays.asList(idArr).contains(pidVal) && !sb.toString().contains(pidVal);
                    if (flag)
                    {
                        //如果当前节点原本有子节点 现在木有了，更新状态
                        sb.append(pidVal).append(",");
                    }
                }
            }
            //批量删除节点
            baseMapper.deleteBatchIds(Arrays.asList(idArr));
            //修改已无子节点的标识
            String[] pidArr = sb.toString().split(",");
            for (String pid : pidArr)
            {
                this.updateOldParentNode(pid);
            }
        } else
        {
            AcmGhxx acmGhxx = this.getById(id);
            if (acmGhxx == null)
            {
                throw new JeecgBootException("未找到对应实体");
            }
            updateOldParentNode(acmGhxx.getPid());
            baseMapper.deleteById(id);
        }
    }

    @Override
    public List<AcmGhxx> queryTreeListNoPage(QueryWrapper<AcmGhxx> queryWrapper)
    {
        List<AcmGhxx> dataList = baseMapper.selectList(queryWrapper);
        List<AcmGhxx> mapList = new ArrayList<>();
        for (AcmGhxx data : dataList)
        {
            String pidVal = data.getPid();
            //递归查询子节点的根节点
            if (pidVal != null && !IAcmGhxxService.NOCHILD.equals(pidVal))
            {
                AcmGhxx rootVal = this.getTreeRoot(pidVal);
                if (rootVal != null && !mapList.contains(rootVal))
                {
                    mapList.add(rootVal);
                }
            } else
            {
                if (!mapList.contains(data))
                {
                    mapList.add(data);
                }
            }
        }
        return mapList;
    }

    @Override
    public List<SelectTreeModel> queryListByCode(String parentCode)
    {
        String pid = ROOT_PID_VALUE;
        if (oConvertUtils.isNotEmpty(parentCode))
        {
            LambdaQueryWrapper<AcmGhxx> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(AcmGhxx::getPid, parentCode);
            List<AcmGhxx> list = baseMapper.selectList(queryWrapper);
            if (list == null || list.size() == 0)
            {
                throw new JeecgBootException("该编码【" + parentCode + "】不存在，请核实!");
            }
            if (list.size() > 1)
            {
                throw new JeecgBootException("该编码【" + parentCode + "】存在多个，请核实!");
            }
            pid = list.get(0).getId();
        }
        return baseMapper.queryListByPid(pid, null);
    }

    @Override
    public List<SelectTreeModel> queryListByPid(String pid)
    {
        if (oConvertUtils.isEmpty(pid))
        {
            pid = ROOT_PID_VALUE;
        }
        return baseMapper.queryListByPid(pid, null);
    }

    /**
     * 根据所传pid查询旧的父级节点的子节点并修改相应状态值
     *
     * @param pid
     */
    private void updateOldParentNode(String pid)
    {
        if (!IAcmGhxxService.ROOT_PID_VALUE.equals(pid))
        {
            Long count = baseMapper.selectCount(new QueryWrapper<AcmGhxx>().eq("pid", pid));
            if (count == null || count <= 1)
            {
                baseMapper.updateTreeNodeStatus(pid, IAcmGhxxService.NOCHILD);
            }
        }
    }

    /**
     * 递归查询节点的根节点
     *
     * @param pidVal
     * @return
     */
    private AcmGhxx getTreeRoot(String pidVal)
    {
        AcmGhxx data = baseMapper.selectById(pidVal);
        if (data != null && !IAcmGhxxService.ROOT_PID_VALUE.equals(data.getPid()))
        {
            return this.getTreeRoot(data.getPid());
        } else
        {
            return data;
        }
    }

    /**
     * 根据id查询所有子节点id
     *
     * @param ids
     * @return
     */
    private String queryTreeChildIds(String ids)
    {
        //获取id数组
        String[] idArr = ids.split(",");
        StringBuffer sb = new StringBuffer();
        for (String pidVal : idArr)
        {
            if (pidVal != null)
            {
                if (!sb.toString().contains(pidVal))
                {
                    if (sb.toString().length() > 0)
                    {
                        sb.append(",");
                    }
                    sb.append(pidVal);
                    this.getTreeChildIds(pidVal, sb);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 递归查询所有子节点
     *
     * @param pidVal
     * @param sb
     * @return
     */
    private StringBuffer getTreeChildIds(String pidVal, StringBuffer sb)
    {
        List<AcmGhxx> dataList = baseMapper.selectList(new QueryWrapper<AcmGhxx>().eq("pid", pidVal));
        if (dataList != null && dataList.size() > 0)
        {
            for (AcmGhxx tree : dataList)
            {
                if (!sb.toString().contains(tree.getId()))
                {
                    sb.append(",").append(tree.getId());
                }
                this.getTreeChildIds(tree.getId(), sb);
            }
        }
        return sb;
    }

}
