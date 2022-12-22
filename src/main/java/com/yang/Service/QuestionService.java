package com.yang.Service;

import com.yang.Exception.errCode;
import com.yang.Exception.exception;
import com.yang.Model.Question;
import com.yang.Model.QuestionExample;
import com.yang.Model.User;
import com.yang.Dto.PageDto;
import com.yang.Dto.QuestionDto;
import com.yang.mapper.QuestionExtMapper;
import com.yang.mapper.QuestionMapper;
import com.yang.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Log4j
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    public PageDto list(Integer page, Integer size) {
        PageDto pageDtos = new PageDto();

        Integer totalPage;
        QuestionExample questionExample = new QuestionExample();
        Integer totalCount = (int) questionMapper.countByExample(questionExample);

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = (totalCount / size) + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        pageDtos.setPagination(totalPage, page);

        Integer offset = size * (page - 1);
        QuestionExample questionExample1 = new QuestionExample();
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(questionExample1, new RowBounds(offset, size));
//        questionExample1.createCriteria()
//                        .andCustomerIdEqualTo()
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCustomerId());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);
//            questionDto.setId(question.getId());
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        pageDtos.setQuestions(questionDtoList);

        return pageDtos;
    }

    public PageDto list(Long userId, Integer page, Integer size) {
        PageDto pageDtos = new PageDto();
        Integer totalPage;
        QuestionExample questionExample2 = new QuestionExample();
        questionExample2.createCriteria()
                .andCustomerIdEqualTo(userId);
        Integer totalCount = (int) questionMapper.countByExample(questionExample2);
//        Integer totalCount = questionMapper.countByUserId(userId);

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = (totalCount / size) + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        pageDtos.setPagination(totalPage, page);

        Integer offset = (size * (page - 1)) + 5;
        QuestionExample questionExample1 = new QuestionExample();
        questionExample1.createCriteria()
                .andCustomerIdEqualTo(userId);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(questionExample1, new RowBounds(offset, size));
//        List<Question> questions = questionMapper.listByUserId(userId, offset, size);
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCustomerId());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        pageDtos.setQuestions(questionDtoList);

        return pageDtos;
    }

    public QuestionDto getById(Long id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null) {
            throw new exception(errCode.QUESTION_NOT_FOUND);
        }
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question, questionDto);
        User user = userMapper.selectByPrimaryKey(question.getCustomerId());
        questionDto.setUser(user);
        return questionDto;
    }

    public void CreateOrUpdate(Question question) {
        if (question.getId() == null) {
            // create
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            question.setReadVolume(0);
            question.setCommentVolume(0);
            question.setLikeVolume(0);
            questionMapper.insert(question);
        } else {
            // update
            question.setGmtModified(question.getGmtCreate());
            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(System.currentTimeMillis());
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria()
                    .andIdEqualTo(question.getId());
            int updated = questionMapper.updateByExampleSelective(updateQuestion, questionExample);
            if (updated != 1) {
                throw new exception(errCode.QUESTION_NOT_FOUND);
            }
        }
    }

    public void incView(Long id) {
        Question question = new Question();
        question.setId(id);
        question.setReadVolume(1);
        questionExtMapper.incView(question);
    }
}
