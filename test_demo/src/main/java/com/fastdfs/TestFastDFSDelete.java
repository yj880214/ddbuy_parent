package com.fastdfs;

import org.csource.fastdfs.*;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/26
 * @Time: 14:52
 **/
//删除上传的图片
public class TestFastDFSDelete {
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
  //6 通过存储客户端操作：删除
   int i =storageClient.delete_file("group1", "M00/00/00/wKgBHl58vXuALnaDAADULrzKuvI661.jpg");
   System.out.println("i = " + i);
   if (i!=0)
      System.out.println("删除成功！ ");
   else
      System.out.println("删除失败！");

  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}
