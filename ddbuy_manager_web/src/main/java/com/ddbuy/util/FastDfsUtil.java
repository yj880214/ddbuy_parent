package com.ddbuy.util;

import org.csource.fastdfs.*;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/30
 * @Time: 14:54
 **/
//fastdfs上传图片的工具类
public class FastDfsUtil {
  //编写图片上传方法：
  // fastdfs工具类返回数据：文件上传信息string数组--location+图片相对路径
 public static String[] uploadFile(byte[] bs,String extname){//文件和上传后文件扩展名
    //fastdfs图片上传六步骤:最终通过storage客户端执行图片上传

  try {
   //1 读取fastdfs配置
   ClientGlobal.init("fastdfs.properties");
   //2 创建Tracker客户端对象
   TrackerClient trackerClient=new TrackerClient();
   //3 创建连接对象
   TrackerServer trackerServer = trackerClient.getConnection();
   //4 创建storage服务器(初始化)
   StorageServer storageServer=null;
   //5 创建storage客户端对象
   StorageClient storageClient=new StorageClient(trackerServer,storageServer);
   //6 执行图片上传
   String[] strings = storageClient.upload_file(bs, extname, null);
   //执行上传需要参数：图片，文件扩展名
   return strings;
  } catch (Exception e) {
   e.printStackTrace();
  }

  return null;
 }



}
