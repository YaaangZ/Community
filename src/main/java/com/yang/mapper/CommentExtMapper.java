package com.yang.mapper;

import com.yang.Model.Comment;
import com.yang.Model.Question;


public interface CommentExtMapper {
    int incCommentCount(Comment comment);

    int incLike(Comment comment);
}