package com.ddbuy;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration   //添加dubbo支持，首先需要将dubbo依赖导入pom文件
@MapperScan("com.ddbuy.mapper")  //扫描mapper接口
public class DdbuyCommonServiceApplication {

 public static void main(String[] args) {
  SpringApplication.run(DdbuyCommonServiceApplication.class, args);
 }

}
