package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.TbContendService;
import com.ddbuy.entity.TbContent;
import com.ddbuy.util.FastDfsUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/27
 * @Time: 10:30
 **/
//广告管理控制器
 //广告添加含有图片操作（特殊商品）
 //添加其他商品，以及其他含有图片的信息添加

@Controller
public class TbContentController {

 @Value("${nginx.fastdfs.address}")    //指定值的引用
 private String nginx_fastdfs_address;

 @Reference(interfaceClass = TbContendService.class)
 private TbContendService tbContendService;
 //添加广告
 @RequestMapping(value = "/addContent",produces = "application/json")
 public String addContent(TbContent tbContent, @RequestParam("file") MultipartFile file){

  try {
//一 实现广告图片上传
   //1、获取文件文件全名
   String filename = file.getOriginalFilename();
   //2 文件扩展名获取：文件全名中除了最后一个点之后的字符串，通过substring截取
   // filename.lastIndexOf(".") 获取的字符"·"的下标位置：数字
   //filename.substring(从哪个位置开始截取字符串) 123.jpg
   String extname = filename.substring(filename.lastIndexOf(".")+1);
   //3 调用fastdfs图片上传工具类：需要参数-文件字节，文件扩展名
   String[] strings = FastDfsUtil.uploadFile(file.getBytes(), extname);
   System.out.println("图片上传成功！");
   //第一个元素：组名group1  第二个元素：图片位置
// 二 数据更新添加到数据库:添加广告，注意将图片路径也要添加
   if (strings!=null){
//     String url="http://192.168.1.30:80"+"/"+strings[0]+"/"+strings[1];
    String url=nginx_fastdfs_address+"/"+strings[0]+"/"+strings[1];
    //将图片信息添加到数据(广告对象)--->
     tbContent.setPic(url);
    //调用业务工程执行添加
    tbContendService.addTbContent(tbContent);
    System.out.println("添加成功");
   }
     return "{\"result\":1}";
  } catch (Exception e) {
   e.printStackTrace();
     return "{\"result\":0}";
  }

 }



}
