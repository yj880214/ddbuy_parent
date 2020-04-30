package com.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/21
 * @Time: 14:44
 **/
//修改
public class SolrTest3Update {
 public static void main(String[] args) {
  try {
   //
      String url="http://localhost:8181/solr/";
      //
  HttpSolrClient solrClient=new HttpSolrClient.Builder(url+"new_core").build();
     //修改的思路--先删除，再添加
   solrClient.deleteByQuery("xh:25");
   //添加
   SolrInputDocument document=new SolrInputDocument();
   document.addField("xh",25);
   document.addField("name","杰少");
   document.addField("age",22);
   document.addField("sex","男");
   solrClient.add(document);
   solrClient.commit();
   System.out.println("修改成功！");
  } catch (Exception e) {
   e.printStackTrace();
   System.out.println("有异常！");
  }

 }
}
