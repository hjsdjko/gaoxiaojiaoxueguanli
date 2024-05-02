package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 工作量
 *
 * @author 
 * @email
 * @date 2021-03-20
 */
@TableName("gongzuoliang")
public class GongzuoliangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongzuoliangEntity() {

	}

	public GongzuoliangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 分配老师
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 工作量
     */
    @TableField(value = "gongzhuo")

    private Integer gongzhuo;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "jilu_time",fill = FieldFill.UPDATE)

    private Date jiluTime;


    /**
     * 分配内容
     */
    @TableField(value = "xiangqing_content")

    private String xiangqingContent;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：分配老师
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：分配老师
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：工作量
	 */
    public Integer getGongzhuo() {
        return gongzhuo;
    }


    /**
	 * 获取：工作量
	 */

    public void setGongzhuo(Integer gongzhuo) {
        this.gongzhuo = gongzhuo;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getJiluTime() {
        return jiluTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setJiluTime(Date jiluTime) {
        this.jiluTime = jiluTime;
    }
    /**
	 * 设置：分配内容
	 */
    public String getXiangqingContent() {
        return xiangqingContent;
    }


    /**
	 * 获取：分配内容
	 */

    public void setXiangqingContent(String xiangqingContent) {
        this.xiangqingContent = xiangqingContent;
    }

    @Override
    public String toString() {
        return "Gongzuoliang{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", gongzhuo=" + gongzhuo +
            ", jiluTime=" + jiluTime +
            ", xiangqingContent=" + xiangqingContent +
        "}";
    }
}
