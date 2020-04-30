package com.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/20
 * @Time: 15:27
 **/
//案例：solr操作--添加索引（添加域）  xh,name,age,sex
public class SolrTest1Add {
 public static void main(String[] args) {
  try {
      String url="http://localhost:8181/solr/";
        //1 创建solr服务器对象  http
       //HttpSolrClient solrClient=new HttpSolrClient().Builder(url+"new_core");
        HttpSolrClient solrClient=new HttpSolrClient.Builder(url+"new_core").build();
       //2 document操作对象  索引（域-值）对应map
      SolrInputDocument document=new SolrInputDocument();
    /*      Map<String,Object> map=new HashMap<>();
          //添加数据
          map.put("xh",110);
          map.put("name","王五");
          map.put("age",20);
          map.put("sex","男");
          //取值
      System.out.println("添加的新学生学号："+map.get("xh"));*/
        document.addField("xh",421);
        document.addField("name","wangwu");
        document.addField("age",19);
        document.addField("sex","男");

           //添加索引
        UpdateResponse add = solrClient.add(document);
        solrClient.commit(); //更新提交
        if (add!=null)
             System.out.println("操作成功！");
        else
             System.out.println("操作失败，请检查完毕重新操作！");
  } catch (Exception e) {
      e.printStackTrace();
      System.out.println("有异常，请检查完毕重新操作");
  }


 }
}
