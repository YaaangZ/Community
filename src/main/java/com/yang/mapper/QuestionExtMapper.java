package com.yang.mapper;

import com.yang.Model.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface QuestionExtMapper {
    int incView(@Param("record") Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);
}