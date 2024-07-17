package com.entity.model;

import com.entity.FanxiaoshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生返校申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FanxiaoshenqingModel implements Serializable {
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
     * 申请编号
     */
    private String fanxiaoshenqingUuidNumber;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请返校日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fanxiaoshenqingTime;


    /**
     * 健康码
     */
    private String jiankangmaPhoto;


    /**
     * 行程码
     */
    private String xingchengmaPhoto;


    /**
     * 核酸报告
     */
    private String hesuanbaogaoPhoto;


    /**
     * 申请理由
     */
    private String fanxiaoshenqingContent;


    /**
     * 审核状态
     */
    private Integer fanxiaoshenqingYesnoTypes;


    /**
     * 审核意见
     */
    private String fanxiaoshenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
	 * 获取：申请编号
	 */
    public String getFanxiaoshenqingUuidNumber() {
        return fanxiaoshenqingUuidNumber;
    }


    /**
	 * 设置：申请编号
	 */
    public void setFanxiaoshenqingUuidNumber(String fanxiaoshenqingUuidNumber) {
        this.fanxiaoshenqingUuidNumber = fanxiaoshenqingUuidNumber;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请返校日期
	 */
    public Date getFanxiaoshenqingTime() {
        return fanxiaoshenqingTime;
    }


    /**
	 * 设置：申请返校日期
	 */
    public void setFanxiaoshenqingTime(Date fanxiaoshenqingTime) {
        this.fanxiaoshenqingTime = fanxiaoshenqingTime;
    }
    /**
	 * 获取：健康码
	 */
    public String getJiankangmaPhoto() {
        return jiankangmaPhoto;
    }


    /**
	 * 设置：健康码
	 */
    public void setJiankangmaPhoto(String jiankangmaPhoto) {
        this.jiankangmaPhoto = jiankangmaPhoto;
    }
    /**
	 * 获取：行程码
	 */
    public String getXingchengmaPhoto() {
        return xingchengmaPhoto;
    }


    /**
	 * 设置：行程码
	 */
    public void setXingchengmaPhoto(String xingchengmaPhoto) {
        this.xingchengmaPhoto = xingchengmaPhoto;
    }
    /**
	 * 获取：核酸报告
	 */
    public String getHesuanbaogaoPhoto() {
        return hesuanbaogaoPhoto;
    }


    /**
	 * 设置：核酸报告
	 */
    public void setHesuanbaogaoPhoto(String hesuanbaogaoPhoto) {
        this.hesuanbaogaoPhoto = hesuanbaogaoPhoto;
    }
    /**
	 * 获取：申请理由
	 */
    public String getFanxiaoshenqingContent() {
        return fanxiaoshenqingContent;
    }


    /**
	 * 设置：申请理由
	 */
    public void setFanxiaoshenqingContent(String fanxiaoshenqingContent) {
        this.fanxiaoshenqingContent = fanxiaoshenqingContent;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getFanxiaoshenqingYesnoTypes() {
        return fanxiaoshenqingYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setFanxiaoshenqingYesnoTypes(Integer fanxiaoshenqingYesnoTypes) {
        this.fanxiaoshenqingYesnoTypes = fanxiaoshenqingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getFanxiaoshenqingYesnoText() {
        return fanxiaoshenqingYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setFanxiaoshenqingYesnoText(String fanxiaoshenqingYesnoText) {
        this.fanxiaoshenqingYesnoText = fanxiaoshenqingYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
