package com.ddbuy.mapper;

import com.ddbuy.entity.TbItem;
import com.ddbuy.entity.TbItemExample;
import com.ddbuy.util.ProductSolr;

import java.util.List;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemExample example);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    //添加接口：solr搜索，查询商品--实体 ProductSolr
    List<ProductSolr> getProductSolr();


}