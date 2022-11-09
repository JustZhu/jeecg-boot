package org.jeecg.modules.demo.com.acm.async.entity;

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
 * @Description: pub_organ
 * @Author: jeecg-boot
 * @Date:   2022-11-08
 * @Version: V1.0
 */
@Data
@TableName("pub_organ")
@ApiModel(value="pub_organ对象", description="pub_organ")
public class PubOrgan implements Serializable {
    private static final long serialVersionUID = 1L;

	/**organId*/
	@Excel(name = "organId", width = 15)
    @ApiModelProperty(value = "organId")
    private java.lang.String organId;
	/**organCode*/
	@Excel(name = "organCode", width = 15)
    @ApiModelProperty(value = "organCode")
    private java.lang.String organCode;
	/**organName*/
	@Excel(name = "organName", width = 15)
    @ApiModelProperty(value = "organName")
    private java.lang.String organName;
	/**parentId*/
	@Excel(name = "parentId", width = 15)
    @ApiModelProperty(value = "parentId")
    private java.lang.String parentId;
	/**organType*/
	@Excel(name = "organType", width = 15)
    @ApiModelProperty(value = "organType")
    private java.lang.String organType;
	/**struPath*/
	@Excel(name = "struPath", width = 15)
    @ApiModelProperty(value = "struPath")
    private java.lang.String struPath;
	/**struOrder*/
	@Excel(name = "struOrder", width = 15)
    @ApiModelProperty(value = "struOrder")
    private java.lang.String struOrder;
	/**isLeaf*/
	@Excel(name = "isLeaf", width = 15)
    @ApiModelProperty(value = "isLeaf")
    private java.lang.String isLeaf;
	/**ctime*/
	@Excel(name = "ctime", width = 15)
    @ApiModelProperty(value = "ctime")
    private java.lang.String ctime;
	/**inUse*/
	@Excel(name = "inUse", width = 15)
    @ApiModelProperty(value = "inUse")
    private java.lang.String inUse;

}
