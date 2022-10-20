package com.yang.mapper;

import com.yang.Model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into tb_user (account_id, name, token, gmt_create, gmt_modified, photo_url) values (${accountId}, #{name}, #{token}, #{gmtCreate}, #{gmtModified}, #{photo_url})" )
    void insert(User user);

    @Select("select * from tb_user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from tb_user where id = #{id}")
    User findByid(@Param("id") Integer id);

    @Select("select * from tb_user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId")String accountId);

    @Update("update tb_user set name = #{name}, token = #{token}, gmt_modified = #{gmtModified}, photo_url = #{photo_url} where id = #{id}")
    void update(User user);
}
