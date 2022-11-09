package com.labor.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @Description: labor_comp_jn
 * @Author: jeecg-boot
 * @Date: 2022-11-08
 * @Version: V1.0
 */
@Data
@TableName("labor_comp_jn")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "labor_comp_jn对象", description = "labor_comp_jn")
public class LaborCompJn implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * laborName
     */
    @Excel(name = "laborName", width = 15)
    @ApiModelProperty(value = "laborName")
    private java.lang.String laborName;
    /**
     * laborCode
     */
    @Excel(name = "laborCode", width = 15)
    @ApiModelProperty(value = "laborCode")
    private java.lang.String laborCode;
    /**
     * laborType
     */
    @Excel(name = "laborType", width = 15)
    @ApiModelProperty(value = "laborType")
    private java.lang.String laborType;
    /**
     * ucode
     */
    @Excel(name = "ucode", width = 15)
    @ApiModelProperty(value = "ucode")
    private java.lang.String ucode;
    /**
     * leader
     */
    @Excel(name = "leader", width = 15)
    @ApiModelProperty(value = "leader")
    private java.lang.String leader;
    /**
     * aphone
     */
    @Excel(name = "aphone", width = 15)
    @ApiModelProperty(value = "aphone")
    private java.lang.String aphone;
    /**
     * flaborName
     */
    @Excel(name = "flaborName", width = 15)
    @ApiModelProperty(value = "flaborName")
    private java.lang.String flaborName;
    /**
     * laborId
     */
    @Excel(name = "laborId", width = 15)
    @ApiModelProperty(value = "laborId")
    private java.lang.String laborId;
    /**
     * zzlx
     */
    @Excel(name = "zzlx", width = 15)
    @ApiModelProperty(value = "zzlx")
    private java.lang.String zzlx;
    /**
     * zzjglx
     */
    @Excel(name = "zzjglx", width = 15)
    @ApiModelProperty(value = "zzjglx")
    private java.lang.String zzjglx;
    /**
     * qxid
     */
    @Excel(name = "qxid", width = 15)
    @ApiModelProperty(value = "qxid")
    private java.lang.String qxid;
    /**
     * qxname
     */
    @Excel(name = "qxname", width = 15)
    @ApiModelProperty(value = "qxname")
    private java.lang.String qxname;
    /**
     * qxcode
     */
    @Excel(name = "qxcode", width = 15)
    @ApiModelProperty(value = "qxcode")
    private java.lang.String qxcode;
    /**
     * jdid
     */
    @Excel(name = "jdid", width = 15)
    @ApiModelProperty(value = "jdid")
    private java.lang.String jdid;
    /**
     * jdname
     */
    @Excel(name = "jdname", width = 15)
    @ApiModelProperty(value = "jdname")
    private java.lang.String jdname;
    /**
     * jdcode
     */
    @Excel(name = "jdcode", width = 15)
    @ApiModelProperty(value = "jdcode")
    private java.lang.String jdcode;
    /**
     * 单位名称
     */
    @Excel(name = "单位名称", width = 15)
    @ApiModelProperty(value = "单位名称")
    private java.lang.String companyName;
    /**
     * 单位统一社会信用代码
     */
    @Excel(name = "单位统一社会信用代码", width = 15)
    @ApiModelProperty(value = "单位统一社会信用代码")
    private java.lang.String companyCreditCode;


    /**
     * organId
     */
    @Excel(name = "organId", width = 15)
    @ApiModelProperty(value = "organId")
    private java.lang.String organId;
    /**
     * organCode
     */
    @Excel(name = "organCode", width = 15)
    @ApiModelProperty(value = "organCode")
    private java.lang.String organCode;
    /**
     * organName
     */
    @Excel(name = "organName", width = 15)
    @ApiModelProperty(value = "organName")
    private java.lang.String organName;
    /**
     * parentId
     */
    @Excel(name = "parentId", width = 15)
    @ApiModelProperty(value = "parentId")
    private java.lang.String parentId;
    /**
     * organType
     */
    @Excel(name = "organType", width = 15)
    @ApiModelProperty(value = "organType")
    private java.lang.String organType;
    /**
     * struPath
     */
    @Excel(name = "struPath", width = 15)
    @ApiModelProperty(value = "struPath")
    private java.lang.String struPath;
    /**
     * struOrder
     */
    @Excel(name = "struOrder", width = 15)
    @ApiModelProperty(value = "struOrder")
    private java.lang.String struOrder;
    /**
     * isLeaf
     */
    @Excel(name = "isLeaf", width = 15)
    @ApiModelProperty(value = "isLeaf")
    private java.lang.String isLeaf;
    /**
     * ctime
     */
    @Excel(name = "ctime", width = 15)
    @ApiModelProperty(value = "ctime")
    private java.lang.String ctime;
    /**
     * inUse
     */
    @Excel(name = "inUse", width = 15)
    @ApiModelProperty(value = "inUse")
    private java.lang.String inUse;

}
