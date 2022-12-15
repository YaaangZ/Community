package com.yang.Service;

import com.yang.Exception.errCode;
import com.yang.Exception.exception;
import com.yang.Model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new exception(errCode.TARGET_PARAM_NOT_FOUND);
        }
    }
}
