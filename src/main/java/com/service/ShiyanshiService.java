package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShiyanshiEntity;
import java.util.Map;

/**
 * 核算 服务类
 * @author 
 * @since 2021-03-20
 */
public interface ShiyanshiService extends IService<ShiyanshiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}