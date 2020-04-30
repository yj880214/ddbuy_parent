package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HelloController {

 @Reference(interfaceClass = HelloService.class)
 private HelloService helloService;

 @RequestMapping("/getHello")
 @ResponseBody //直接返回数据，如果没有此主机，返回页面(名称)
 public String getData(){
  //调用业务
   return helloService.getHello();
 }

}
