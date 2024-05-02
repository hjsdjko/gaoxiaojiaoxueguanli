package com.entity.model;

import com.entity.ShiyanshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 核算
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-20
 */
public class ShiyanshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 核算名称
     */
    private String name;


    /**
     * 详情文件
     */
    private String wenjianFile;


    /**
     * 核算时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date hesuanTime;


    /**
     * 核算结果
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieguoTypes;


    /**
     * 核算详情
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
	 * 获取：核算名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 设置：核算名称
	 */
    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 获取：详情文件
	 */
    public String getWenjianFile() {
        return wenjianFile;
    }


    /**
	 * 设置：详情文件
	 */
    public void setWenjianFile(String wenjianFile) {
        this.wenjianFile = wenjianFile;
    }
    /**
	 * 获取：核算时间
	 */
    public Date getHesuanTime() {
        return hesuanTime;
    }


    /**
	 * 设置：核算时间
	 */
    public void setHesuanTime(Date hesuanTime) {
        this.hesuanTime = hesuanTime;
    }
    /**
	 * 获取：核算结果
	 */
    public Date getJieguoTypes() {
        return jieguoTypes;
    }


    /**
	 * 设置：核算结果
	 */
    public void setJieguoTypes(Date jieguoTypes) {
        this.jieguoTypes = jieguoTypes;
    }
    /**
	 * 获取：核算详情
	 */
    public String getXiangqingContent() {
        return xiangqingContent;
    }


    /**
	 * 设置：核算详情
	 */
    public void setXiangqingContent(String xiangqingContent) {
        this.xiangqingContent = xiangqingContent;
    }

    }
