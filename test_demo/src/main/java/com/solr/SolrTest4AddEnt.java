package com.solr;

import com.entity.Student;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/20
 * @Time: 15:27
 **/
//案例：solr操作--添加对象  xh,name,age,sex
public class SolrTest4AddEnt {
 public static void main(String[] args) {
  try {
      String url="http://localhost:8181/solr/";
        //1 创建solr服务器对象  http
       //HttpSolrClient solrClient=new HttpSolrClient().Builder(url+"new_core");
        HttpSolrClient solrClient=new HttpSolrClient.Builder(url+"new_core").build();
       Student student=new Student(421,"马云",45,"男");
           //将对象添加
        UpdateResponse add = solrClient.addBean(student);
        solrClient.commit(); //更新提交
        if (add!=null)
             System.out.println("添加成功！");
        else
             System.out.println("操作失败，请检查完毕重新操作！");
  } catch (Exception e) {
      e.printStackTrace();
      System.out.println("有异常，请检查完毕重新操作");
  }


 }
}
