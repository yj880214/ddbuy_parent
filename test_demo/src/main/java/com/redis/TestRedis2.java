package com.redis;

import redis.clients.jedis.Jedis;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/7
 * @Time: 10:12
 **/
//测试Reidis:POM中添加操作redis的依赖--jedis
public class TestRedis2 {
 public static void main(String[] args) {
  //操作Redis三步骤：
  // 1 创建jedis对象--连接redis
  Jedis jedis=new Jedis("localhost",6379);
  //判断是否存在列表：
  if (jedis.exists("nameList")) //
     jedis.del("nameList");
  // 2 jedis对象操作redis
  jedis.lpush("nameList", "李四", "王五", "12345");
  //输出指定位置的元素值
  String s = jedis.lindex("nameList", 2);
  System.out.println("第三个元素为： " + s);
  //循环输出列表中的元素/值
  //获取列表长度
  Long len = jedis.llen("nameList");
  System.out.println("列表中元素/值有：");
  for (int i=0;i<len;i++){
    //获取列表中的元素并输出
   System.out.println(jedis.lindex("nameList",i));
  }
  // 3 关闭资源
  jedis.close();
 }
}
