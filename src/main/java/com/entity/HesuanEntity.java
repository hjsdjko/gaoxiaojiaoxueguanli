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
 * 核算
 *
 * @author 
 * @email
 * @date 2021-03-20
 */
@TableName("hesuan")
public class HesuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HesuanEntity() {

	}

	public HesuanEntity(T t) {
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
     * 核算名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 详情文件
     */
    @TableField(value = "wenjian_file")

    private String wenjianFile;


    /**
     * 核算时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "hesuan_time",fill = FieldFill.UPDATE)

    private Date hesuanTime;


    /**
     * 核算结果
     */
    @TableField(value = "jieguo_types")

    private Integer jieguoTypes;


    /**
     * 核算详情
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
	 * 设置：核算名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：核算名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：详情文件
	 */
    public String getWenjianFile() {
        return wenjianFile;
    }


    /**
	 * 获取：详情文件
	 */

    public void setWenjianFile(String wenjianFile) {
        this.wenjianFile = wenjianFile;
    }
    /**
	 * 设置：核算时间
	 */
    public Date getHesuanTime() {
        return hesuanTime;
    }


    /**
	 * 获取：核算时间
	 */

    public void setHesuanTime(Date hesuanTime) {
        this.hesuanTime = hesuanTime;
    }
    /**
	 * 设置：核算结果
	 */
    public Integer getJieguoTypes() {
        return jieguoTypes;
    }


    /**
	 * 获取：核算结果
	 */

    public void setJieguoTypes(Integer jieguoTypes) {
        this.jieguoTypes = jieguoTypes;
    }
    /**
	 * 设置：核算详情
	 */
    public String getXiangqingContent() {
        return xiangqingContent;
    }


    /**
	 * 获取：核算详情
	 */

    public void setXiangqingContent(String xiangqingContent) {
        this.xiangqingContent = xiangqingContent;
    }

    @Override
    public String toString() {
        return "Hesuan{" +
            "id=" + id +
            ", name=" + name +
            ", wenjianFile=" + wenjianFile +
            ", hesuanTime=" + hesuanTime +
            ", jieguoTypes=" + jieguoTypes +
            ", xiangqingContent=" + xiangqingContent +
        "}";
    }
}
