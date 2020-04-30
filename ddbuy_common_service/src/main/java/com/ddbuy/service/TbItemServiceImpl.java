package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.TbItemService;
import com.ddbuy.mapper.TbItemMapper;
import com.ddbuy.util.ProductSolr;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/24
 * @Time: 9:59
 **/
//商品业务工程
@Service(interfaceClass = TbItemService.class)
@Component
public class TbItemServiceImpl implements TbItemService {

 @Autowired(required = false)
 TbItemMapper tbItemMapper;

 //添加商品索引
 @Override
 public boolean importIndex() {

  //目标：将获取的商品信息（主要）作为索引添加到solr
      //1 查询获取信息：调用持久层，mapper
      List<ProductSolr> productList = tbItemMapper.getProductSolr();
  try {
      //2 添加索引
      String url="http://localhost:8181/solr/";
      HttpSolrClient solrClient=new HttpSolrClient.Builder(url+"new_core").build();
      //执行添加
      solrClient.addBeans(productList);
      solrClient.commit();
      return true;
  } catch (Exception e) {
   e.printStackTrace();
  }
  return false;
 }
//首页商品搜索
 @Override
 public Map<String, Object> searchSolr(String condition, Integer page) {
  try {
     if (condition==null)
        condition="*";
     if (page==null)
         page=1;
   //1 solr客户端
    String url="http://localhost:8181/solr/";
    HttpSolrClient solrClient=new HttpSolrClient.Builder(url+"new_core").build();
    //2 通过客户端执行查询
    // 创建查询对象
    SolrQuery solrQuery=new SolrQuery();
    //设置条件   query.set("q","*:*");
    solrQuery.set("q","title:"+condition);
    //返回结果：
    QueryResponse response = solrClient.query(solrQuery);
    //获取商品
   List<ProductSolr> list = response.getBeans(ProductSolr.class);
   Map<String,Object> map=new HashMap<>();
   map.put("list",list);
   return map;
  } catch (Exception e) {
   e.printStackTrace();
  }
  return null;
 }
}
