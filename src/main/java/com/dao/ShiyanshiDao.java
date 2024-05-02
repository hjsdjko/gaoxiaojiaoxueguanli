package com.dao;

import com.entity.ShiyanshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiyanshiView;

/**
 * 核算 Dao 接口
 *
 * @author 
 * @since 2021-03-20
 */
public interface ShiyanshiDao extends BaseMapper<ShiyanshiEntity> {

   List<ShiyanshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
