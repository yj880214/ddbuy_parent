package com.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/21
 * @Time: 10:12
 **/
//删除
public class SolrTest2Del {
 public static void main(String[] args) {
  try {
     //指定solr连接--服务器
      String url="http://localhost:8181/solr/";
      //创建solr对象
     HttpSolrClient solrClient=new HttpSolrClient.Builder(url+"new_core").build();

     //删除操作
   UpdateResponse  result= solrClient.deleteByQuery("name:马化腾");
     solrClient.commit();
   if (result!=null)
        System.out.println("删除成功！");
   else
        System.out.println("删除失败");
  } catch (Exception e) {
      e.printStackTrace();
   System.out.println("有异常！");
  }

 }
}
