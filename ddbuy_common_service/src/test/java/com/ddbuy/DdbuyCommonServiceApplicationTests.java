package com.ddbuy;

import com.ddbuy.service.TbContentCategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DdbuyCommonServiceApplicationTests {
 @Autowired //本地自动注入
 private TbContentCategoryServiceImpl tbTest;
 @Test
 public void testService() {
  System.out.println("进入测试---ok");
  //调用业务测试
  int i = tbTest.getTbContentCategory().size();
  System.out.println("i = " + i);
  System.out.println(tbTest.getTbContentCategory());
 }

}
