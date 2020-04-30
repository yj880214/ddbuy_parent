package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.HelloService;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService {

 @Override
 public String getHello() {
   return "Hello!"; //提供了服务：返回hello字符串
 }
}
