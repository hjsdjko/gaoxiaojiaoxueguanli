package com.entity.model;

import com.entity.JiaoxueruziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教学日志
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-20
 */
public class JiaoxueruziModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 日志名称
     */
    private String name;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiluTime;


    /**
     * 日志内容
     */
    private String xiangqingContent;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：日志名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 设置：日志名称
	 */
    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getJiluTime() {
        return jiluTime;
    }


    /**
	 * 设置：记录时间
	 */
    public void setJiluTime(Date jiluTime) {
        this.jiluTime = jiluTime;
    }
    /**
	 * 获取：日志内容
	 */
    public String getXiangqingContent() {
        return xiangqingContent;
    }


    /**
	 * 设置：日志内容
	 */
    public void setXiangqingContent(String xiangqingContent) {
        this.xiangqingContent = xiangqingContent;
    }

    }
