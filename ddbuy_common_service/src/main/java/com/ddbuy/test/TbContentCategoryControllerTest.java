package com.ddbuy.test;

import com.ddbuy.TbContentCategoryService;
import com.ddbuy.entity.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/17
 * @Time: 15:13
 **/
//业务功能测试类
@Controller
public class TbContentCategoryControllerTest {
 @Autowired
 private TbContentCategoryService tbContentCategoryService;

 @RequestMapping("/getTbTest")
 @ResponseBody
 public List<TbContentCategory> getTbContentCategory(){
  //调用业务实现的方法
  List<TbContentCategory> list = tbContentCategoryService.getTbContentCategory();
  System.out.println("测试业务工程");
  return list;
 }



}
