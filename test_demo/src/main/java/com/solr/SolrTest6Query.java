package com.solr;

import com.entity.Student;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.util.List;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/22
 * @Time: 10:13
 **/
//solr查询
public class SolrTest6Query {
 public static void main(String[] args) {
  try {
  String url="http://localhost:8181/solr/";
    HttpSolrClient solrClient=new HttpSolrClient.Builder(url+"new_core").build();
   //创建查询对象
    SolrQuery query=new SolrQuery();
   //设置查询条件
    query.set("q","*:*");
/*    query.setStart(3);  //设置分页当前页起始下标
    query.setRows(3);   //设置每页条数-记录*/
    //设置排序
    query.setSort("xh",SolrQuery.ORDER.asc); //对年龄升序asc
    //执行查询
   QueryResponse response = solrClient.query(query);
   List<Student> list = response.getBeans(Student.class);
   if (list.size()!=0){
       //输出显示查询的结果
       System.out.println("操作成功，查询结果如下：");
       for (Student student : list) {
           System.out.println("student = " + student);
       }
   }else {
      System.out.println("未查到相关信息，请重新操作！");
   }

/*    //类比条件搜索
   TbContentExample example=new TbContentExample();//广告条件搜索对象
   TbContentExample.Criteria criteria=example.createCriteria();//条件对象
   criteria.andStatusEqualTo("1");//设置搜索条件 set("status:1")
   //调用业务...*/

  } catch (Exception e) {
   e.printStackTrace();
  }

 }
}
