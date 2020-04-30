package com.solr;

import com.entity.Student;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/22
 * @Time: 9:51
 **/
//添加集合:组成一个一个student
public class SolrTest5AddList {

 public static void main(String[] args) {

  try {    //
      String url="http://localhost:8181/solr/";
      HttpSolrClient solrClient=new HttpSolrClient.Builder(url+"new_core").build();

      List<Student> list=new ArrayList<>();
      list.add(new Student(001,"马化腾",38,"男"));
      list.add(new Student(002,"李彦宏",35,"男"));
      list.add(new Student(003,"董明珠",30,"女"));

      UpdateResponse response = solrClient.addBeans(list);
      solrClient.commit();
   if (response!=null)
        System.out.println("集合测试添加成功！");
   else System.out.println("集合测试添加失败！");
  } catch (Exception e) {
      e.printStackTrace();
      System.out.println("有异常，请检查后重新操作！");
  }

 }
}
