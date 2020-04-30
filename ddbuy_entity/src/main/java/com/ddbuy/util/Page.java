package com.ddbuy.util;

import java.io.Serializable;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/20
 * @Time: 14:52
 **/
public class Page implements Serializable {
    //定义分页属性：当前页面、每页条数。
  private Integer page=1;
  private Integer rows=5;

 public Page() {
 }

 public Page(Integer page, Integer rows) {
  this.page = page;
  this.rows = rows;
 }

 public Integer getPage() {
  return page;
 }

 public void setPage(Integer page) {
  this.page = page;
 }

 public Integer getRows() {
  return rows;
 }

 public void setRows(Integer rows) {
  this.rows = rows;
 }
}
