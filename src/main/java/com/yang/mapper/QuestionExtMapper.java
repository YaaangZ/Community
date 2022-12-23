package com.yang.mapper;

import com.yang.Model.Question;
import org.apache.ibatis.annotations.Param;


public interface QuestionExtMapper {
    int incView(@Param("record") Question record);

    int incCommentCount(Question record);
}