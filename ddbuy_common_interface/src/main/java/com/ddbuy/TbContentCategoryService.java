package com.ddbuy;


import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.util.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/17
 * @Time: 14:42
 **/
//广告类型的接口
public interface TbContentCategoryService {
  //1 查询所有广告类型 （返回广告类型的集合）
  public List<TbContentCategory> getTbContentCategory();
// 查询广告类型，分页：
// 分页要素，1页面即当前页；2 总记录数 。封装到工具类中
public PageInfo<TbContentCategory> getTbContentCategory(Page page);

}
