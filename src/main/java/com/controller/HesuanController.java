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

import com.entity.HesuanEntity;

import com.service.HesuanService;
import com.entity.view.HesuanView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 核算
 * 后端接口
 * @author
 * @email
 * @date 2021-03-20
*/
@RestController
@Controller
@RequestMapping("/hesuan")
public class HesuanController {
    private static final Logger logger = LoggerFactory.getLogger(HesuanController.class);

    @Autowired
    private HesuanService hesuanService;


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
        PageUtils page = hesuanService.queryPage(params);

        //字典表数据转换
        List<HesuanView> list =(List<HesuanView>)page.getList();
        for(HesuanView c:list){
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
        HesuanEntity hesuan = hesuanService.selectById(id);
        if(hesuan !=null){
            //entity转view
            HesuanView view = new HesuanView();
            BeanUtils.copyProperties( hesuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody HesuanEntity hesuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,hesuan:{}",this.getClass().getName(),hesuan.toString());
        Wrapper<HesuanEntity> queryWrapper = new EntityWrapper<HesuanEntity>()
            .eq("name", hesuan.getName())
            .eq("jieguo_types", hesuan.getJieguoTypes())
            .eq("xiangqing_content", hesuan.getXiangqingContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HesuanEntity hesuanEntity = hesuanService.selectOne(queryWrapper);
        if(hesuanEntity==null){
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      hesuan.set
        //  }
            hesuanService.insert(hesuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HesuanEntity hesuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,hesuan:{}",this.getClass().getName(),hesuan.toString());
        //根据字段查询是否有相同数据
        Wrapper<HesuanEntity> queryWrapper = new EntityWrapper<HesuanEntity>()
            .notIn("id",hesuan.getId())
            .andNew()
            .eq("name", hesuan.getName())
            .eq("jieguo_types", hesuan.getJieguoTypes())
            .eq("xiangqing_content", hesuan.getXiangqingContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HesuanEntity hesuanEntity = hesuanService.selectOne(queryWrapper);
        if("".equals(hesuan.getWenjianFile()) || "null".equals(hesuan.getWenjianFile())){
                hesuan.setWenjianFile(null);
        }
                hesuan.setHesuanTime(new Date());
        if(hesuanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      hesuan.set
            //  }
            hesuanService.updateById(hesuan);//根据id更新
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
        hesuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

