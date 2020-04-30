package com.ddbuy.mapper;

import com.ddbuy.entity.TbContent;
import com.ddbuy.entity.TbContentExample;
import java.util.List;

public interface TbContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);
//添加广告
    int insertSelective(TbContent record);
//查询所有广告
    List<TbContent> selectByExample(TbContentExample example);

    TbContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKey(TbContent record);
}