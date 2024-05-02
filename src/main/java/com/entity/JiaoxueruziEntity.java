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
 * 教学日志
 *
 * @author 
 * @email
 * @date 2021-03-20
 */
@TableName("jiaoxueruzi")
public class JiaoxueruziEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaoxueruziEntity() {

	}

	public JiaoxueruziEntity(T t) {
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
     * 日志名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "jilu_time",fill = FieldFill.UPDATE)

    private Date jiluTime;


    /**
     * 日志内容
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
	 * 设置：日志名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：日志名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getJiluTime() {
        return jiluTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setJiluTime(Date jiluTime) {
        this.jiluTime = jiluTime;
    }
    /**
	 * 设置：日志内容
	 */
    public String getXiangqingContent() {
        return xiangqingContent;
    }


    /**
	 * 获取：日志内容
	 */

    public void setXiangqingContent(String xiangqingContent) {
        this.xiangqingContent = xiangqingContent;
    }

    @Override
    public String toString() {
        return "Jiaoxueruzi{" +
            "id=" + id +
            ", name=" + name +
            ", jiluTime=" + jiluTime +
            ", xiangqingContent=" + xiangqingContent +
        "}";
    }
}
