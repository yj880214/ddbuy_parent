package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.TbItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/24
 * @Time: 14:48
 **/

//商品操作：搜索
@Controller
public class ImportIndex {

  @Reference(interfaceClass = TbItemService.class,timeout = 3000)
  private TbItemService tbItemService;

 //创建商品索引
 @RequestMapping("/searchSolr")
 public String importIndex(){
  //如果索引导入成功，就返回页面--展示信息还是提示；
  //否则(失败)，跳转错误或提示页面
    //调用添加索引的业务，执行
   if (tbItemService.importIndex()) {
    System.out.println("索引添加成功！");
    return "ok";
   }else{
    System.out.println("索引添加失败！");
    return "fail";
    }
  
 }
 //首页商品搜索
  @RequestMapping("/search")
 public String searchSolr(String condition, Integer page, Model model){
     // 调用业务工程
   Map<String, Object> map = tbItemService.searchSolr(condition, page);
   //此时，已经从solr获取到了数据。将数据在页面显示。
   model.addAttribute("info",map);

   return "searchList";//返回页面
  }
 
}
