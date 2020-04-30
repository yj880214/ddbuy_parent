package com.fastdfs;

import org.csource.fastdfs.*;

import java.util.Date;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/26
 * @Time: 14:52
 **/
//查看上传的图片信息
public class TestFastDFSCheck {
 public static void main(String[] args) {
// 六步骤（FastDFS三个角色：TrackerServer、StorageServer、Client）
  try {
   //1 加载配置
   ClientGlobal.init("fastdfs.properties");
   //2 创建tracker客户端对象
   TrackerClient trackerClient=new TrackerClient();
   //3 通过客户端对象创建连接（服务器）
   TrackerServer trackerServer = trackerClient.getConnection();
   //4 创建存储服务器对象
   StorageServer storageServer=null;
   //5 创建存储客户端对象
   StorageClient storageClient=new StorageClient(trackerServer,storageServer);
  //6 通过存储客户端操作：查看（通过FileInfo对象存放获取的文件信息）
   FileInfo fileInfo = storageClient.get_file_info("group1", "M00/00/00/wKgBHl58x6WAHDH3AAvea_OGt2M525.jpg");

   long size = fileInfo.getFileSize();
   System.out.println("图片大小 = " + size);
   Date date = fileInfo.getCreateTimestamp();
   System.out.println("上传时间 = " + date);
   String ipAddr = fileInfo.getSourceIpAddr();
   System.out.println("图片服务器地址 = " + ipAddr);


  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}
