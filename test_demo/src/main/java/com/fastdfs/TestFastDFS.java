package com.fastdfs;

import org.csource.fastdfs.*;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/26
 * @Time: 9:59
 **/
//测试fastdfs上传图片
public class TestFastDFS {
 // Fastdfs三个重要角色:
 // 跟踪服务器-TrackerServer、 存储服务器-StorageServer、客户端-Client）
 //fastdfs上传图片步骤

 public static void main(String[] args) {

  try {
   //1 加载配置 fastdfs.properties
   ClientGlobal.init("fastdfs.properties");
   //2 创建客户端对象
   TrackerClient trackerClient=new TrackerClient();
   //3 创建对象连接
   TrackerServer trackerServer=trackerClient.getConnection();
   //4 创建存储服务器
   StorageServer storageServer=null;
   //5 创建存储客户端：对象连接、存储对象
   StorageClient storageClient=new StorageClient(trackerServer,storageServer);
   //6 使用存储客户端上传图片
   String[] strings = storageClient.upload_file("C:\\Users\\Public\\Pictures\\Sample Pictures\\2.jpg", "jpg", null);
//输出上传后 的文件信息
   for (String string : strings) {
    System.out.println("string = " + string);
   }

  } catch (Exception e) {
   e.printStackTrace();
  }
 }

}
