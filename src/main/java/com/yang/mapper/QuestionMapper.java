package com.yang.mapper;

import com.yang.Model.Question;
import com.yang.dto.QuestionDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into tb_question (title, description, gmt_create, gmt_modified, customer_id, comment_volume, read_volume, like_volume, tag) " +
            "values (#{title}, #{description}, #{gmt_create}, #{gmt_modified}, #{customer_id}, #{comment_volume}, #{read_volume}, #{like_volume}, #{tag})")
    void create(Question question);

    @Select("select * from tb_question")
    List<Question> list();
}
