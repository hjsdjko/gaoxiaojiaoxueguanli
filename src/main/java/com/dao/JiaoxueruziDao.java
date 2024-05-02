package com.dao;

import com.entity.JiaoxueruziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoxueruziView;

/**
 * 教学日志 Dao 接口
 *
 * @author 
 * @since 2021-03-20
 */
public interface JiaoxueruziDao extends BaseMapper<JiaoxueruziEntity> {

   List<JiaoxueruziView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
