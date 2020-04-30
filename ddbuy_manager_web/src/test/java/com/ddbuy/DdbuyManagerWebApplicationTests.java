package com.ddbuy;

import com.ddbuy.controller.TbContentCategoryController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DdbuyManagerWebApplicationTests {

 @Autowired
 private TbContentCategoryController tbContentCategoryController;

 @Test
 public void testWeb() {
  System.out.println("测试web工程");
  //调用工程业务测试
/*  List<TbContentCategory> list = tbContentCategoryController.getTbContentCategory();
  System.out.println("web工程测试信息长度："+list.size());
  System.out.println("广告分类信息测试："+list);*/


 }

}
