package com.ddbuy;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DdbuySearchWeb2Application {

 public static void main(String[] args) {
  SpringApplication.run(DdbuySearchWeb2Application.class, args);
 }

}
