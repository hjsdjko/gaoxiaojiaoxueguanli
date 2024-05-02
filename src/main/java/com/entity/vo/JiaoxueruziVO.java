package com.entity.vo;

import com.entity.JiaoxueruziEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 教学日志
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-20
 */
@TableName("jiaoxueruzi")
public class JiaoxueruziVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "jilu_time")
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

}
