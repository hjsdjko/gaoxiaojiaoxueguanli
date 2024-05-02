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

import com.entity.GongzuoliangEntity;

import com.service.GongzuoliangService;
import com.entity.view.GongzuoliangView;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 工作量
 * 后端接口
 * @author
 * @email
 * @date 2021-03-20
*/
@RestController
@Controller
@RequestMapping("/gongzuoliang")
public class GongzuoliangController {
    private static final Logger logger = LoggerFactory.getLogger(GongzuoliangController.class);

    @Autowired
    private GongzuoliangService gongzuoliangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "教师".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = gongzuoliangService.queryPage(params);

        //字典表数据转换
        List<GongzuoliangView> list =(List<GongzuoliangView>)page.getList();
        for(GongzuoliangView c:list){
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
        GongzuoliangEntity gongzuoliang = gongzuoliangService.selectById(id);
        if(gongzuoliang !=null){
            //entity转view
            GongzuoliangView view = new GongzuoliangView();
            BeanUtils.copyProperties( gongzuoliang , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(gongzuoliang.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody GongzuoliangEntity gongzuoliang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongzuoliang:{}",this.getClass().getName(),gongzuoliang.toString());
        Wrapper<GongzuoliangEntity> queryWrapper = new EntityWrapper<GongzuoliangEntity>()
            .eq("yonghu_id", gongzuoliang.getYonghuId())
            .eq("gongzhuo", gongzuoliang.getGongzhuo())
            .eq("xiangqing_content", gongzuoliang.getXiangqingContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongzuoliangEntity gongzuoliangEntity = gongzuoliangService.selectOne(queryWrapper);
        if(gongzuoliangEntity==null){
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      gongzuoliang.set
        //  }
            gongzuoliangService.insert(gongzuoliang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongzuoliangEntity gongzuoliang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongzuoliang:{}",this.getClass().getName(),gongzuoliang.toString());
        //根据字段查询是否有相同数据
        Wrapper<GongzuoliangEntity> queryWrapper = new EntityWrapper<GongzuoliangEntity>()
            .notIn("id",gongzuoliang.getId())
            .andNew()
            .eq("yonghu_id", gongzuoliang.getYonghuId())
            .eq("gongzhuo", gongzuoliang.getGongzhuo())
            .eq("xiangqing_content", gongzuoliang.getXiangqingContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongzuoliangEntity gongzuoliangEntity = gongzuoliangService.selectOne(queryWrapper);
                gongzuoliang.setJiluTime(new Date());
        if(gongzuoliangEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      gongzuoliang.set
            //  }
            gongzuoliangService.updateById(gongzuoliang);//根据id更新
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
        gongzuoliangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

