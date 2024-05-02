package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.JiaoxueruziDao;
import com.entity.JiaoxueruziEntity;
import com.service.JiaoxueruziService;
import com.entity.view.JiaoxueruziView;

/**
 * 教学日志 服务实现类
 * @author 
 * @since 2021-03-20
 */
@Service("jiaoxueruziService")
@Transactional
public class JiaoxueruziServiceImpl extends ServiceImpl<JiaoxueruziDao, JiaoxueruziEntity> implements JiaoxueruziService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JiaoxueruziView> page =new Query<JiaoxueruziView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
