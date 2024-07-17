package com.dao;

import com.entity.FanxiaoshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FanxiaoshenqingView;

/**
 * 学生返校申请 Dao 接口
 *
 * @author 
 */
public interface FanxiaoshenqingDao extends BaseMapper<FanxiaoshenqingEntity> {

   List<FanxiaoshenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
