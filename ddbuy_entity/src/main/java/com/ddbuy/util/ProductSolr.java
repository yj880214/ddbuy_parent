package com.ddbuy.util;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/23
 * @Time: 15:15
 **/
//solr搜索商品实体：
public class ProductSolr implements Serializable {
   //定义四个要素
   @Field
   private Long pid; //商品编号
   @Field
   private Double price;//商品价格
   @Field
   private String image;//图片
   @Field
   private String title;//标题

 public ProductSolr() {
 }

 public ProductSolr(Long pid, Double price, String image, String title) {
  this.pid = pid;
  this.price = price;
  this.image = image;
  this.title = title;
 }

 public Long getPid() {
  return pid;
 }

 public void setPid(Long pid) {
  this.pid = pid;
 }

 public Double getPrice() {
  return price;
 }

 public void setPrice(Double price) {
  this.price = price;
 }

 public String getImage() {
  return image;
 }

 public void setImage(String image) {
  this.image = image;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 @Override
 public String toString() {
  return "ProductSolr{" +
   "pid=" + pid +
   ", price=" + price +
   ", image='" + image + '\'' +
   ", title='" + title + '\'' +
   '}';
 }
}
