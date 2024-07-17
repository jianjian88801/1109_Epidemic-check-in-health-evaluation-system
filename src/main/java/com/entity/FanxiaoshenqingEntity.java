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
 * 学生返校申请
 *
 * @author 
 * @email
 */
@TableName("fanxiaoshenqing")
public class FanxiaoshenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FanxiaoshenqingEntity() {

	}

	public FanxiaoshenqingEntity(T t) {
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
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 申请编号
     */
    @TableField(value = "fanxiaoshenqing_uuid_number")

    private String fanxiaoshenqingUuidNumber;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请返校日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "fanxiaoshenqing_time")

    private Date fanxiaoshenqingTime;


    /**
     * 健康码
     */
    @TableField(value = "jiankangma_photo")

    private String jiankangmaPhoto;


    /**
     * 行程码
     */
    @TableField(value = "xingchengma_photo")

    private String xingchengmaPhoto;


    /**
     * 核酸报告
     */
    @TableField(value = "hesuanbaogao_photo")

    private String hesuanbaogaoPhoto;


    /**
     * 申请理由
     */
    @TableField(value = "fanxiaoshenqing_content")

    private String fanxiaoshenqingContent;


    /**
     * 审核状态
     */
    @TableField(value = "fanxiaoshenqing_yesno_types")

    private Integer fanxiaoshenqingYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "fanxiaoshenqing_yesno_text")

    private String fanxiaoshenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


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
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：申请编号
	 */
    public String getFanxiaoshenqingUuidNumber() {
        return fanxiaoshenqingUuidNumber;
    }
    /**
	 * 获取：申请编号
	 */

    public void setFanxiaoshenqingUuidNumber(String fanxiaoshenqingUuidNumber) {
        this.fanxiaoshenqingUuidNumber = fanxiaoshenqingUuidNumber;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请返校日期
	 */
    public Date getFanxiaoshenqingTime() {
        return fanxiaoshenqingTime;
    }
    /**
	 * 获取：申请返校日期
	 */

    public void setFanxiaoshenqingTime(Date fanxiaoshenqingTime) {
        this.fanxiaoshenqingTime = fanxiaoshenqingTime;
    }
    /**
	 * 设置：健康码
	 */
    public String getJiankangmaPhoto() {
        return jiankangmaPhoto;
    }
    /**
	 * 获取：健康码
	 */

    public void setJiankangmaPhoto(String jiankangmaPhoto) {
        this.jiankangmaPhoto = jiankangmaPhoto;
    }
    /**
	 * 设置：行程码
	 */
    public String getXingchengmaPhoto() {
        return xingchengmaPhoto;
    }
    /**
	 * 获取：行程码
	 */

    public void setXingchengmaPhoto(String xingchengmaPhoto) {
        this.xingchengmaPhoto = xingchengmaPhoto;
    }
    /**
	 * 设置：核酸报告
	 */
    public String getHesuanbaogaoPhoto() {
        return hesuanbaogaoPhoto;
    }
    /**
	 * 获取：核酸报告
	 */

    public void setHesuanbaogaoPhoto(String hesuanbaogaoPhoto) {
        this.hesuanbaogaoPhoto = hesuanbaogaoPhoto;
    }
    /**
	 * 设置：申请理由
	 */
    public String getFanxiaoshenqingContent() {
        return fanxiaoshenqingContent;
    }
    /**
	 * 获取：申请理由
	 */

    public void setFanxiaoshenqingContent(String fanxiaoshenqingContent) {
        this.fanxiaoshenqingContent = fanxiaoshenqingContent;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getFanxiaoshenqingYesnoTypes() {
        return fanxiaoshenqingYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */

    public void setFanxiaoshenqingYesnoTypes(Integer fanxiaoshenqingYesnoTypes) {
        this.fanxiaoshenqingYesnoTypes = fanxiaoshenqingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getFanxiaoshenqingYesnoText() {
        return fanxiaoshenqingYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setFanxiaoshenqingYesnoText(String fanxiaoshenqingYesnoText) {
        this.fanxiaoshenqingYesnoText = fanxiaoshenqingYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
	 * 获取：审核时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Fanxiaoshenqing{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", fanxiaoshenqingUuidNumber=" + fanxiaoshenqingUuidNumber +
            ", insertTime=" + insertTime +
            ", fanxiaoshenqingTime=" + fanxiaoshenqingTime +
            ", jiankangmaPhoto=" + jiankangmaPhoto +
            ", xingchengmaPhoto=" + xingchengmaPhoto +
            ", hesuanbaogaoPhoto=" + hesuanbaogaoPhoto +
            ", fanxiaoshenqingContent=" + fanxiaoshenqingContent +
            ", fanxiaoshenqingYesnoTypes=" + fanxiaoshenqingYesnoTypes +
            ", fanxiaoshenqingYesnoText=" + fanxiaoshenqingYesnoText +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
