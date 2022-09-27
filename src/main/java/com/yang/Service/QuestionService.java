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
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset, size);
        PageDto pageDtos = new PageDto();
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
        Integer totalCount = questionMapper.count();
        pageDtos.setPagination(totalCount, page, size);
        return pageDtos;
    }
}
