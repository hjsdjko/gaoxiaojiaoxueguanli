package com.entity.model;

import com.entity.GongzuoliangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 工作量
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-20
 */
public class GongzuoliangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 分配老师
     */
    private Integer yonghuId;


    /**
     * 工作量
     */
    private Integer gongzhuo;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiluTime;


    /**
     * 分配内容
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
	 * 获取：分配老师
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：分配老师
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：工作量
	 */
    public Integer getGongzhuo() {
        return gongzhuo;
    }


    /**
	 * 设置：工作量
	 */
    public void setGongzhuo(Integer gongzhuo) {
        this.gongzhuo = gongzhuo;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getJiluTime() {
        return jiluTime;
    }


    /**
	 * 设置：发布时间
	 */
    public void setJiluTime(Date jiluTime) {
        this.jiluTime = jiluTime;
    }
    /**
	 * 获取：分配内容
	 */
    public String getXiangqingContent() {
        return xiangqingContent;
    }


    /**
	 * 设置：分配内容
	 */
    public void setXiangqingContent(String xiangqingContent) {
        this.xiangqingContent = xiangqingContent;
    }

    }
