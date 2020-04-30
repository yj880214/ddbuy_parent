package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.TbContentCategoryService;
import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.entity.TbContentCategoryExample;
import com.ddbuy.mapper.TbContentCategoryMapper;
import com.ddbuy.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/17
 * @Time: 14:58
 **/
//广告分类的业务实现（服务提供者）
@Service(interfaceClass = TbContentCategoryService.class)
@Component    //将服务对象暴露
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
// dao-service-controller
 @Autowired(required = false)
 private TbContentCategoryMapper tbContentCategoryMapper;

// 1 普通查询
 @Override
 public List<TbContentCategory > getTbContentCategory() {
  //调用mapper功能，实现获取数据库信息
  return tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
 }

//2 带分页查询
 @Override
 public PageInfo<TbContentCategory> getTbContentCategory(Page page) {
  //返回带分页信息的数据
  //启动分页
  PageHelper.startPage(page.getPage(),page.getRows());
  //获取数据
  List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
  //将数据放进分页对象，使数据封装后具有分页信息
  return new PageInfo<>(list);
 }
}
