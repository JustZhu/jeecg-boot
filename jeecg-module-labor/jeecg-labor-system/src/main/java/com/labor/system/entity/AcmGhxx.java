package com.labor.system.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 工会管理
 * @Author: jeecg-boot
 * @Date:   2022-11-08
 * @Version: V1.0
 */
@Data
@TableName("acm_ghxx")
@ApiModel(value="acm_ghxx对象", description="工会管理")
public class AcmGhxx implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**工会编码*/
	@Excel(name = "工会编码", width = 15)
    @ApiModelProperty(value = "工会编码")
    private java.lang.String ghbm;
	/**工会名称*/
	@Excel(name = "工会名称", width = 15)
    @ApiModelProperty(value = "工会名称")
    private java.lang.String ghmc;
	/**上级工会编码*/
	@Excel(name = "上级工会编码", width = 15)
    @ApiModelProperty(value = "上级工会编码")
    private java.lang.String sjbm;
	/**上级工会名称*/
	@Excel(name = "上级工会名称", width = 15)
    @ApiModelProperty(value = "上级工会名称")
    private java.lang.String sjmc;
	/**区县编码*/
	@Excel(name = "区县编码", width = 15)
    @ApiModelProperty(value = "区县编码")
    private java.lang.String qxbm;
	/**区县名称*/
	@Excel(name = "区县名称", width = 15)
    @ApiModelProperty(value = "区县名称")
    private java.lang.String qxmc;
	/**街道编码*/
	@Excel(name = "街道编码", width = 15)
    @ApiModelProperty(value = "街道编码")
    private java.lang.String jdbm;
	/**街道名称*/
	@Excel(name = "街道名称", width = 15)
    @ApiModelProperty(value = "街道名称")
    private java.lang.String jdmc;
	/**工会法人编码*/
	@Excel(name = "工会法人编码", width = 15)
    @ApiModelProperty(value = "工会法人编码")
    private java.lang.String ghfrbm;
	/**工会法人*/
	@Excel(name = "工会法人", width = 15)
    @ApiModelProperty(value = "工会法人")
    private java.lang.String ghfr;
	/**工会主席编码*/
	@Excel(name = "工会主席编码", width = 15)
    @ApiModelProperty(value = "工会主席编码")
    private java.lang.String ghzxbm;
	/**工会主席*/
	@Excel(name = "工会主席", width = 15)
    @ApiModelProperty(value = "工会主席")
    private java.lang.String ghzx;
	/**工会负责人编码*/
	@Excel(name = "工会负责人编码", width = 15)
    @ApiModelProperty(value = "工会负责人编码")
    private java.lang.String ghfzrbm;
	/**工会负责人*/
	@Excel(name = "工会负责人", width = 15)
    @ApiModelProperty(value = "工会负责人")
    private java.lang.String ghfzr;
	/**联系方式*/
	@Excel(name = "联系方式", width = 15)
    @ApiModelProperty(value = "联系方式")
    private java.lang.String lxfs;
	/**工会类型编码*/
	@Excel(name = "工会类型编码", width = 15)
    @ApiModelProperty(value = "工会类型编码")
    private java.lang.String ghlxbm;
	/**工会类型*/
	@Excel(name = "工会类型", width = 15)
    @ApiModelProperty(value = "工会类型")
    private java.lang.String ghlx;
	/**经济类型编码*/
	@Excel(name = "经济类型编码", width = 15)
    @ApiModelProperty(value = "经济类型编码")
    private java.lang.String jxlxbm;
	/**经济类型*/
	@Excel(name = "经济类型", width = 15)
    @ApiModelProperty(value = "经济类型")
    private java.lang.String jxlx;
	/**建会批复文号*/
	@Excel(name = "建会批复文号", width = 15)
    @ApiModelProperty(value = "建会批复文号")
    private java.lang.String pfwh;
	/**法人资格图片*/
	@Excel(name = "法人资格图片", width = 15)
    @ApiModelProperty(value = "法人资格图片")
    private java.lang.String frzgwj;
	/**批复文件*/
	@Excel(name = "批复文件", width = 15)
    @ApiModelProperty(value = "批复文件")
    private java.lang.String pfwj;
	/**建会日期*/
	@Excel(name = "建会日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "建会日期")
    private java.util.Date jhrq;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String bz;
	/**省总工会编码*/
	@Excel(name = "省总工会编码", width = 15)
    @ApiModelProperty(value = "省总工会编码")
    private java.lang.String szghbm;
	/**全总工会编码*/
	@Excel(name = "全总工会编码", width = 15)
    @ApiModelProperty(value = "全总工会编码")
    private java.lang.String qzghcode;
	/**状态（0正常 1停用）*/
	@Excel(name = "状态（0正常 1停用）", width = 15)
    @ApiModelProperty(value = "状态（0正常 1停用）")
    private java.lang.String status;
	/**排序*/
	@Excel(name = "排序", width = 15)
    @ApiModelProperty(value = "排序")
    private java.lang.Integer orderNum;
	/**删除标志（0代表存在 2代表删除）*/
	@Excel(name = "删除标志（0代表存在 2代表删除）", width = 15)
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    private java.lang.String delFlag;
	/**创建者*/
    @ApiModelProperty(value = "创建者")
    private java.lang.String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
	/**更新者*/
    @ApiModelProperty(value = "更新者")
    private java.lang.String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
	/**父级节点*/
	@Excel(name = "父级节点", width = 15)
    @ApiModelProperty(value = "父级节点")
    private java.lang.String pid;
	/**是否有子节点*/
	@Excel(name = "是否有子节点", width = 15, dicCode = "yn")
	@Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否有子节点")
    private java.lang.String hasChild;
}
