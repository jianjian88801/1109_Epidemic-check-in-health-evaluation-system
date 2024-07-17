package com.entity.model;

import com.entity.XueshengjujiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 居家
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueshengjujiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 居家状态
     */
    private Integer xueshengjujiaZhuangtaiTypes;


    /**
     * 居家日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jujiaTime;


    /**
     * 居家位置
     */
    private String xueshengjujiaAddress;


    /**
     * 居家备注
     */
    private String xueshengjujiaContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


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
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：居家状态
	 */
    public Integer getXueshengjujiaZhuangtaiTypes() {
        return xueshengjujiaZhuangtaiTypes;
    }


    /**
	 * 设置：居家状态
	 */
    public void setXueshengjujiaZhuangtaiTypes(Integer xueshengjujiaZhuangtaiTypes) {
        this.xueshengjujiaZhuangtaiTypes = xueshengjujiaZhuangtaiTypes;
    }
    /**
	 * 获取：居家日期
	 */
    public Date getJujiaTime() {
        return jujiaTime;
    }


    /**
	 * 设置：居家日期
	 */
    public void setJujiaTime(Date jujiaTime) {
        this.jujiaTime = jujiaTime;
    }
    /**
	 * 获取：居家位置
	 */
    public String getXueshengjujiaAddress() {
        return xueshengjujiaAddress;
    }


    /**
	 * 设置：居家位置
	 */
    public void setXueshengjujiaAddress(String xueshengjujiaAddress) {
        this.xueshengjujiaAddress = xueshengjujiaAddress;
    }
    /**
	 * 获取：居家备注
	 */
    public String getXueshengjujiaContent() {
        return xueshengjujiaContent;
    }


    /**
	 * 设置：居家备注
	 */
    public void setXueshengjujiaContent(String xueshengjujiaContent) {
        this.xueshengjujiaContent = xueshengjujiaContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
