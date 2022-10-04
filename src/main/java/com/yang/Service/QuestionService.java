package com.yang.Service;

import com.yang.Model.Question;
import com.yang.Model.User;
import com.yang.dto.PageDto;
import com.yang.dto.QuestionDto;
import com.yang.mapper.QuestionMapper;
import com.yang.mapper.UserMapper;
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

    public PageDto list(Integer page, Integer size) {
        PageDto pageDtos = new PageDto();

        Integer totalPage;
        Integer totalCount = questionMapper.count();

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
        List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findByid(question.getCustomer_id());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);
//            questionDto.setId(question.getId());
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        pageDtos.setQuestions(questionDtoList);

        return pageDtos;
    }

    public PageDto list(Integer userId, Integer page, Integer size) {
        PageDto pageDtos = new PageDto();
        Integer totalPage;
        Integer totalCount = questionMapper.countByUserId(userId);

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
        List<Question> questions = questionMapper.listByUserId(userId, offset, size);
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findByid(question.getCustomer_id());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);
//            questionDto.setId(question.getId());
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        pageDtos.setQuestions(questionDtoList);

        return pageDtos;
    }

    public QuestionDto getById(Integer id) {
        Question question = questionMapper.getById(id);
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question, questionDto);
        User user = userMapper.findByid(question.getCustomer_id());
        questionDto.setUser(user);
        return questionDto;
    }
}
