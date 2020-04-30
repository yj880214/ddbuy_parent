package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.TbContentCategoryService;
import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.util.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/19
 * @Time: 10:21
 **/
//web工程的广告分类(控制器)
@Controller  //springmvc对应--消费者
public class TbContentCategoryController {

@Reference(interfaceClass = TbContentCategoryService.class)
private TbContentCategoryService tbContentCategoryService;

   //调用服务提供者业务--测试三步骤：获取数据，数据在jsp展示，前端EasyUI框架展示
   @RequestMapping("/getTbContentCategory")
   @ResponseBody
/* public List<TbContentCategory> getTbContentCategory(){
    //调用service工程--首先得引入广告分类查询的实现类（对象）
    List<TbContentCategory> list = tbContentCategoryService.getTbContentCategory();
    return list;
   }*/
/*   public String getTbContentCategory(Model model){

     List<TbContentCategory> list = tbContentCategoryService.getTbContentCategory();
     model.addAttribute("tbContentCategoryList",list);
     return "testCategory.jsp";*/
   public Map<String,Object> getTbContentCategory(Page page){ //将分页两个要素返回给前端

    PageInfo<TbContentCategory> pageInfo = tbContentCategoryService.getTbContentCategory(page);
//    model.addAttribute("tbContentCategoryList",list);
    // 通过map传给easyui前端：总记录数、每一条记录
    Map<String,Object> map=new HashMap<>();
    map.put("total",pageInfo.getTotal()); //返回总记录数
    map.put("rows",pageInfo.getList()); //返回每一条记录（所有记录）
    return map;
   }

   //测试jsp访问
   @RequestMapping("/jspTest")
 public String jspTest(){
    return "testCategory.jsp";
   }


   //编码位置：按业务、按模块（工程）
 //广告添加模块中广告类型获取
 @RequestMapping("/getTbContentCategory2")
 @ResponseBody
 public List<TbContentCategory> getTbContentCategory2(Page page){ //将分页两个要素返回给前端
  PageInfo<TbContentCategory> pageInfo = tbContentCategoryService.getTbContentCategory(page);
  System.out.println("pageInfo.getList() = " + pageInfo.getList());   
  return pageInfo.getList();
 }


}
