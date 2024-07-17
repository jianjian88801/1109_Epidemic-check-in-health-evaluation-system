package com.dao;

import com.entity.XueshengjujiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengjujiaView;

/**
 * 居家 Dao 接口
 *
 * @author 
 */
public interface XueshengjujiaDao extends BaseMapper<XueshengjujiaEntity> {

   List<XueshengjujiaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
