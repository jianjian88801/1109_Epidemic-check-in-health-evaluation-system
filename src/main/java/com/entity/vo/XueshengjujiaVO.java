package com.entity.vo;

import com.entity.XueshengjujiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 居家
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xueshengjujia")
public class XueshengjujiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 居家状态
     */

    @TableField(value = "xueshengjujia_zhuangtai_types")
    private Integer xueshengjujiaZhuangtaiTypes;


    /**
     * 居家日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jujia_time")
    private Date jujiaTime;


    /**
     * 居家位置
     */

    @TableField(value = "xueshengjujia_address")
    private String xueshengjujiaAddress;


    /**
     * 居家备注
     */

    @TableField(value = "xueshengjujia_content")
    private String xueshengjujiaContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：居家状态
	 */
    public Integer getXueshengjujiaZhuangtaiTypes() {
        return xueshengjujiaZhuangtaiTypes;
    }


    /**
	 * 获取：居家状态
	 */

    public void setXueshengjujiaZhuangtaiTypes(Integer xueshengjujiaZhuangtaiTypes) {
        this.xueshengjujiaZhuangtaiTypes = xueshengjujiaZhuangtaiTypes;
    }
    /**
	 * 设置：居家日期
	 */
    public Date getJujiaTime() {
        return jujiaTime;
    }


    /**
	 * 获取：居家日期
	 */

    public void setJujiaTime(Date jujiaTime) {
        this.jujiaTime = jujiaTime;
    }
    /**
	 * 设置：居家位置
	 */
    public String getXueshengjujiaAddress() {
        return xueshengjujiaAddress;
    }


    /**
	 * 获取：居家位置
	 */

    public void setXueshengjujiaAddress(String xueshengjujiaAddress) {
        this.xueshengjujiaAddress = xueshengjujiaAddress;
    }
    /**
	 * 设置：居家备注
	 */
    public String getXueshengjujiaContent() {
        return xueshengjujiaContent;
    }


    /**
	 * 获取：居家备注
	 */

    public void setXueshengjujiaContent(String xueshengjujiaContent) {
        this.xueshengjujiaContent = xueshengjujiaContent;
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

}
