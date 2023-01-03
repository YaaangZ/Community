package com.yang.mapper;

import com.yang.Dto.QuestionQueryDto;
import com.yang.Model.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface QuestionExtMapper {
    int incView(Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDto questionQueryDto);

    List<Question> selectBySearch(QuestionQueryDto questionQueryDto);

}