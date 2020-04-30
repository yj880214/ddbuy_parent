package com.ddbuy;

import com.ddbuy.entity.TbContent;

import java.util.List;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/30
 * @Time: 10:20
 **/
//广告的接口(广告管理)
public interface TbContendService {
   //添加广告
  public int addTbContent(TbContent tbContent);
  //查询广告
  public List<TbContent> getTbContent();
}
