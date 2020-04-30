package com.entity;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/21
 * @Time: 15:18
 **/
//学生实体：solr案例
public class Student {
 @Field
  private Integer xh;
 @Field
  private String name;
 @Field
  private Integer age;
 @Field
  private String sex;

 public Student() {
 }

 public Student(Integer xh, String name, Integer age, String sex) {
  this.xh = xh;
  this.name = name;
  this.age = age;
  this.sex = sex;
 }


 public Integer getXh() {
  return xh;
 }

 public void setXh(Integer xh) {
  this.xh = xh;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Integer getAge() {
  return age;
 }

 public void setAge(Integer age) {
  this.age = age;
 }

 public String getSex() {
  return sex;
 }

 public void setSex(String sex) {
  this.sex = sex;
 }

 @Override
 public String toString() {
  return "学生信息：{" +
   "xh=" + xh +
   ", name='" + name+
  "', age =" + age +
   ",sex ='" + sex + '\'' +
   '}';
 }


}
