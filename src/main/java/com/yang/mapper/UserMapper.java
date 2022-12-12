//package com.yang.mapper;
//
//import com.yang.Model.User;
//import org.apache.ibatis.annotations.*;
//
//@Mapper
//public interface UserMapper {
//    @Insert("insert into tb_user (account_id, name, token, gmt_create, gmt_modified, photo_url) values (${accountId}, #{name}, #{token}, #{gmtCreate}, #{gmtModified}, #{photo_url})" )
//    void insert(User user);
//
//    @Select("select * from tb_user where token = #{token}")
//    User findByToken(@Param("token") String token);
//
//    @Select("select * from tb_user where id = #{id}")
//    User findByid(@Param("id") Integer id);
//
//    @Select("select * from tb_user where account_id = #{accountId}")
//    User findByAccountId(@Param("accountId")String accountId);
//
//    @Update("update tb_user set name = #{name}, token = #{token}, gmt_modified = #{gmtModified}, photo_url = #{photo_url} where id = #{id}")
//    void update(User user);
//}
package com.yang.mapper;

import com.yang.Model.User;
import com.yang.Model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 15:38:13 GMT 2022
     */
    int updateByPrimaryKey(User record);
}