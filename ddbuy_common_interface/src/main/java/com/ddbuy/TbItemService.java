package com.ddbuy;

import java.util.Map;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/4/23
 * @Time: 15:30
 **/
//商品接口
public interface TbItemService {
   //添加索引
   public boolean importIndex();
//   首页商品搜索：向solr传递参数--条件和页码
   public Map<String,Object> searchSolr(String condition, Integer page);

}
