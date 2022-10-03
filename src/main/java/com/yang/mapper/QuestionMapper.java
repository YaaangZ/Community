package com.yang.mapper;

import com.yang.Model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into tb_question (title, description, gmt_create, gmt_modified, customer_id, comment_volume, read_volume, like_volume, tag) " +
            "values (#{title}, #{description}, #{gmt_create}, #{gmt_modified}, #{customer_id}, #{comment_volume}, #{read_volume}, #{like_volume}, #{tag})")
    void create(Question question);

    @Select("select * from tb_question limit ${offset}, ${size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from tb_question")
    Integer count();

    @Select("select * from tb_question where customer_id=${userId} limit #{offset}, #{size}")
    List<Question> listByUserId(@Param("userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from tb_question where customer_id = ${userId}")
    Integer countByUserId(@Param("userId") Integer userId);
}
