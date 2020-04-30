package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.TbContendService;
import com.ddbuy.entity.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/8
 * @Time: 15:07
 **/
//门户工程：调用service业务实现数据获取并将结果返回页面
@Controller
public class TbContentController {

  @Reference(interfaceClass = TbContendService.class)
  private TbContendService tbContendService;
 //广告查询
  @RequestMapping("/goIndex")
 public String goIndex(Model model){
   //调用service工程
   List<TbContent> contentList = tbContendService.getTbContent();
   model.addAttribute("contentList",contentList);
//   return contentList;
   return "Index";
  }
}
