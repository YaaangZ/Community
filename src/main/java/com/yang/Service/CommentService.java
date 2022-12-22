package com.yang.Service;

import com.yang.Enums.CommentTypeEnum;
import com.yang.Exception.errCode;
import com.yang.Exception.exception;
import com.yang.Model.Comment;
import com.yang.Model.Question;
import com.yang.mapper.CommentMapper;
import com.yang.mapper.QuestionExtMapper;
import com.yang.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Transactional // open events
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new exception(errCode.TARGET_PARAM_NOT_FOUND);
        }

        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new exception(errCode.TYPE_PARAM_WRONG);
        }

        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            // reply comment
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new exception(errCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        } else {
            //reply question
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new exception(errCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentVolume(1);
            questionExtMapper.incCommentCount(question);
        }
    }
}
