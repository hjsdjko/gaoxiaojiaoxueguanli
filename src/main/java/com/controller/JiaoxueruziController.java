package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JiaoxueruziEntity;

import com.service.JiaoxueruziService;
import com.entity.view.JiaoxueruziView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 教学日志
 * 后端接口
 * @author
 * @email
 * @date 2021-03-20
*/
@RestController
@Controller
@RequestMapping("/jiaoxueruzi")
public class JiaoxueruziController {
    private static final Logger logger = LoggerFactory.getLogger(JiaoxueruziController.class);

    @Autowired
    private JiaoxueruziService jiaoxueruziService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = jiaoxueruziService.queryPage(params);

        //字典表数据转换
        List<JiaoxueruziView> list =(List<JiaoxueruziView>)page.getList();
        for(JiaoxueruziView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaoxueruziEntity jiaoxueruzi = jiaoxueruziService.selectById(id);
        if(jiaoxueruzi !=null){
            //entity转view
            JiaoxueruziView view = new JiaoxueruziView();
            BeanUtils.copyProperties( jiaoxueruzi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoxueruziEntity jiaoxueruzi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaoxueruzi:{}",this.getClass().getName(),jiaoxueruzi.toString());
        Wrapper<JiaoxueruziEntity> queryWrapper = new EntityWrapper<JiaoxueruziEntity>()
            .eq("name", jiaoxueruzi.getName())
            .eq("xiangqing_content", jiaoxueruzi.getXiangqingContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoxueruziEntity jiaoxueruziEntity = jiaoxueruziService.selectOne(queryWrapper);
        if(jiaoxueruziEntity==null){
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jiaoxueruzi.set
        //  }
            jiaoxueruziService.insert(jiaoxueruzi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaoxueruziEntity jiaoxueruzi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaoxueruzi:{}",this.getClass().getName(),jiaoxueruzi.toString());
        //根据字段查询是否有相同数据
        Wrapper<JiaoxueruziEntity> queryWrapper = new EntityWrapper<JiaoxueruziEntity>()
            .notIn("id",jiaoxueruzi.getId())
            .andNew()
            .eq("name", jiaoxueruzi.getName())
            .eq("xiangqing_content", jiaoxueruzi.getXiangqingContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoxueruziEntity jiaoxueruziEntity = jiaoxueruziService.selectOne(queryWrapper);
                jiaoxueruzi.setJiluTime(new Date());
        if(jiaoxueruziEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jiaoxueruzi.set
            //  }
            jiaoxueruziService.updateById(jiaoxueruzi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiaoxueruziService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

