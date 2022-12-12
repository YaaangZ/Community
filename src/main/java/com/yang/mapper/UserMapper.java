package com.yang.mapper;

import com.yang.Model.User;
import com.yang.Model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_USER
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    int updateByPrimaryKey(User record);
}