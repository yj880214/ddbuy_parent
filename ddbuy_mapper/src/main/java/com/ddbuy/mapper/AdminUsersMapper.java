package com.ddbuy.mapper;

import com.ddbuy.entity.AdminUsers;
import com.ddbuy.entity.AdminUsersExample;
import java.util.List;

public interface AdminUsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdminUsers record);

    int insertSelective(AdminUsers record);

    List<AdminUsers> selectByExample(AdminUsersExample example);

    AdminUsers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminUsers record);

    int updateByPrimaryKey(AdminUsers record);
}