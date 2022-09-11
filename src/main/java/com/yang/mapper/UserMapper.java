package com.yang.mapper;

import com.yang.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into tb_user (id, account_id, name, token, gmt_create, gmt_modified) values (#{id}, #{accountId}, #{name}, #{token}, #{gmtCreate}, #{gmtModified})" )
    void insert(User user);
}
