
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
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
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 学生返校申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fanxiaoshenqing")
public class FanxiaoshenqingController {
    private static final Logger logger = LoggerFactory.getLogger(FanxiaoshenqingController.class);

    @Autowired
    private FanxiaoshenqingService fanxiaoshenqingService;


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
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fanxiaoshenqingService.queryPage(params);

        //字典表数据转换
        List<FanxiaoshenqingView> list =(List<FanxiaoshenqingView>)page.getList();
        for(FanxiaoshenqingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FanxiaoshenqingEntity fanxiaoshenqing = fanxiaoshenqingService.selectById(id);
        if(fanxiaoshenqing !=null){
            //entity转view
            FanxiaoshenqingView view = new FanxiaoshenqingView();
            BeanUtils.copyProperties( fanxiaoshenqing , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(fanxiaoshenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FanxiaoshenqingEntity fanxiaoshenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fanxiaoshenqing:{}",this.getClass().getName(),fanxiaoshenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            fanxiaoshenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FanxiaoshenqingEntity> queryWrapper = new EntityWrapper<FanxiaoshenqingEntity>()
            .eq("yonghu_id", fanxiaoshenqing.getYonghuId())
            .eq("fanxiaoshenqing_uuid_number", fanxiaoshenqing.getFanxiaoshenqingUuidNumber())
            .eq("fanxiaoshenqing_time", new SimpleDateFormat("yyyy-MM-dd").format(fanxiaoshenqing.getFanxiaoshenqingTime()))
            .eq("fanxiaoshenqing_yesno_types", fanxiaoshenqing.getFanxiaoshenqingYesnoTypes())
            .eq("fanxiaoshenqing_yesno_text", fanxiaoshenqing.getFanxiaoshenqingYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FanxiaoshenqingEntity fanxiaoshenqingEntity = fanxiaoshenqingService.selectOne(queryWrapper);
        if(fanxiaoshenqingEntity==null){
            fanxiaoshenqing.setInsertTime(new Date());
            fanxiaoshenqing.setFanxiaoshenqingYesnoTypes(1);
            fanxiaoshenqing.setCreateTime(new Date());
            fanxiaoshenqingService.insert(fanxiaoshenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FanxiaoshenqingEntity fanxiaoshenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fanxiaoshenqing:{}",this.getClass().getName(),fanxiaoshenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            fanxiaoshenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<FanxiaoshenqingEntity> queryWrapper = new EntityWrapper<FanxiaoshenqingEntity>()
            .notIn("id",fanxiaoshenqing.getId())
            .andNew()
            .eq("yonghu_id", fanxiaoshenqing.getYonghuId())
            .eq("fanxiaoshenqing_uuid_number", fanxiaoshenqing.getFanxiaoshenqingUuidNumber())
            .eq("insert_time", fanxiaoshenqing.getInsertTime())
            .eq("fanxiaoshenqing_time", fanxiaoshenqing.getFanxiaoshenqingTime())
            .eq("fanxiaoshenqing_yesno_types", fanxiaoshenqing.getFanxiaoshenqingYesnoTypes())
            .eq("fanxiaoshenqing_yesno_text", fanxiaoshenqing.getFanxiaoshenqingYesnoText())
            .eq("update_time", fanxiaoshenqing.getUpdateTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FanxiaoshenqingEntity fanxiaoshenqingEntity = fanxiaoshenqingService.selectOne(queryWrapper);
        if("".equals(fanxiaoshenqing.getJiankangmaPhoto()) || "null".equals(fanxiaoshenqing.getJiankangmaPhoto())){
                fanxiaoshenqing.setJiankangmaPhoto(null);
        }
        if("".equals(fanxiaoshenqing.getXingchengmaPhoto()) || "null".equals(fanxiaoshenqing.getXingchengmaPhoto())){
                fanxiaoshenqing.setXingchengmaPhoto(null);
        }
        if("".equals(fanxiaoshenqing.getHesuanbaogaoPhoto()) || "null".equals(fanxiaoshenqing.getHesuanbaogaoPhoto())){
                fanxiaoshenqing.setHesuanbaogaoPhoto(null);
        }
        fanxiaoshenqing.setUpdateTime(new Date());
        if(fanxiaoshenqingEntity==null){
            fanxiaoshenqingService.updateById(fanxiaoshenqing);//根据id更新
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
        fanxiaoshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FanxiaoshenqingEntity> fanxiaoshenqingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FanxiaoshenqingEntity fanxiaoshenqingEntity = new FanxiaoshenqingEntity();
//                            fanxiaoshenqingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            fanxiaoshenqingEntity.setFanxiaoshenqingUuidNumber(data.get(0));                    //申请编号 要改的
//                            fanxiaoshenqingEntity.setInsertTime(date);//时间
//                            fanxiaoshenqingEntity.setFanxiaoshenqingTime(sdf.parse(data.get(0)));          //申请返校日期 要改的
//                            fanxiaoshenqingEntity.setJiankangmaPhoto("");//详情和图片
//                            fanxiaoshenqingEntity.setXingchengmaPhoto("");//详情和图片
//                            fanxiaoshenqingEntity.setHesuanbaogaoPhoto("");//详情和图片
//                            fanxiaoshenqingEntity.setFanxiaoshenqingContent("");//详情和图片
//                            fanxiaoshenqingEntity.setFanxiaoshenqingYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            fanxiaoshenqingEntity.setFanxiaoshenqingYesnoText(data.get(0));                    //审核意见 要改的
//                            fanxiaoshenqingEntity.setUpdateTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            fanxiaoshenqingEntity.setCreateTime(date);//时间
                            fanxiaoshenqingList.add(fanxiaoshenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //申请编号
                                if(seachFields.containsKey("fanxiaoshenqingUuidNumber")){
                                    List<String> fanxiaoshenqingUuidNumber = seachFields.get("fanxiaoshenqingUuidNumber");
                                    fanxiaoshenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fanxiaoshenqingUuidNumber = new ArrayList<>();
                                    fanxiaoshenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fanxiaoshenqingUuidNumber",fanxiaoshenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //申请编号
                        List<FanxiaoshenqingEntity> fanxiaoshenqingEntities_fanxiaoshenqingUuidNumber = fanxiaoshenqingService.selectList(new EntityWrapper<FanxiaoshenqingEntity>().in("fanxiaoshenqing_uuid_number", seachFields.get("fanxiaoshenqingUuidNumber")));
                        if(fanxiaoshenqingEntities_fanxiaoshenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FanxiaoshenqingEntity s:fanxiaoshenqingEntities_fanxiaoshenqingUuidNumber){
                                repeatFields.add(s.getFanxiaoshenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fanxiaoshenqingService.insertBatch(fanxiaoshenqingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fanxiaoshenqingService.queryPage(params);

        //字典表数据转换
        List<FanxiaoshenqingView> list =(List<FanxiaoshenqingView>)page.getList();
        for(FanxiaoshenqingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FanxiaoshenqingEntity fanxiaoshenqing = fanxiaoshenqingService.selectById(id);
            if(fanxiaoshenqing !=null){


                //entity转view
                FanxiaoshenqingView view = new FanxiaoshenqingView();
                BeanUtils.copyProperties( fanxiaoshenqing , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fanxiaoshenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FanxiaoshenqingEntity fanxiaoshenqing, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fanxiaoshenqing:{}",this.getClass().getName(),fanxiaoshenqing.toString());
        Wrapper<FanxiaoshenqingEntity> queryWrapper = new EntityWrapper<FanxiaoshenqingEntity>()
            .eq("yonghu_id", fanxiaoshenqing.getYonghuId())
            .eq("fanxiaoshenqing_uuid_number", fanxiaoshenqing.getFanxiaoshenqingUuidNumber())
            .eq("fanxiaoshenqing_yesno_types", fanxiaoshenqing.getFanxiaoshenqingYesnoTypes())
            .eq("fanxiaoshenqing_yesno_text", fanxiaoshenqing.getFanxiaoshenqingYesnoText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FanxiaoshenqingEntity fanxiaoshenqingEntity = fanxiaoshenqingService.selectOne(queryWrapper);
        if(fanxiaoshenqingEntity==null){
            fanxiaoshenqing.setInsertTime(new Date());
            fanxiaoshenqing.setFanxiaoshenqingYesnoTypes(1);
            fanxiaoshenqing.setCreateTime(new Date());
        fanxiaoshenqingService.insert(fanxiaoshenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
