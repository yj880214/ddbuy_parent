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
public class TestRedis {
 public static void main(String[] args) {
  //操作Redis三步骤：
  // 1 创建jedis对象--连接redis
  Jedis jedis=new Jedis("localhost",6379);
  // 2 jedis对象操作redis
  jedis.set("name", "张三");
  jedis.set("age","16");
  String age = jedis.get("age");
  int i = Integer.parseInt(age);
  int j=i+1;
  System.out.println("j = " + j);//1输出结果17
  System.out.println(i+1);//2输出结果17
  System.out.println("i+1 = " + i+1);//输出结果161
  System.out.println("j = "+(i+1));//3输出结果17
  System.out.println("测试 1= " + i+"2");//162
  System.out.println("测试 2= " + 1+i);//116


  //获取值
  String name = jedis.get("name");
  System.out.println("name为： " + name);
  //设置有效期
//  jedis.expire("name",60);
  //查看剩余生存时间
  System.out.println("剩余时间为："+jedis.ttl("name"));
  //删除
 /* Long del = jedis.del("name");
  System.out.println("del = " + del);*/
  //判断是否存在
  Boolean b = jedis.exists("name");
  System.out.println("name是否存在？ = " + b);
  // 追加字符串
  jedis.append("name","123abc");
  System.out.println("更新的name为: "+jedis.get("name"));
  //BITCOUNT 就是统计字符串的二级制码中，有多少个'1'
  Long bitcount = jedis.bitcount("name");
  System.out.println("bitcount = " + bitcount);
  // 3 关闭资源
  jedis.close();
 }

}
