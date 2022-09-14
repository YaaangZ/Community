package com.yang.mapper;

import com.yang.Model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    @Insert("insert into tb_question (id, title, description, gmt_create, gmt_modified, customer_id, comment_volume, read_volume, like_volume, tag) " +
            "values (#{id}, #{title}, #{description}, #{gmt_create}, #{gmt_modified}, #{customer_id}, #{comment_volume}, #{read_volume}, #{like_volume}, #{tag})")
    void create(Question question);
}
