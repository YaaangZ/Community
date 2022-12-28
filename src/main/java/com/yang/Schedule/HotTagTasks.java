package com.yang.Schedule;

import com.yang.Cache.HotTagCache;
import com.yang.Model.Question;
import com.yang.Model.QuestionExample;
import com.yang.mapper.QuestionMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class HotTagTasks {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private HotTagCache hotTagCache;

    @Scheduled(fixedRate = 10000)
//    @Scheduled(fixedRate = 1000 * 60 * 60 * 3)
    public void hotTagSchedule() {
        int offset = 0;
        int limit = 20;
        log.info("hotTagSchedule start {}", new Date());
        List<Question> list = new ArrayList<>();
        Map<String, Integer> priorities = new HashMap<>();
        while (offset == 0 || list.size() == limit) {
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, limit));
            for (Question question : list) {
                String[] tags = StringUtils.split(question.getTag(), ",");
                for (String eachTag : tags) {
                    Integer priority = priorities.get(eachTag);
                    if (priority != null) {
                        priorities.put(eachTag, priority + 5 + question.getCommentVolume());
                    } else {
                        priorities.put(eachTag, 5 + question.getCommentVolume());
                    }
                }
            }
            offset += limit;
        }
        hotTagCache.setTags(priorities);
        hotTagCache.updateTags(priorities);
        log.info("hotTagSchedule end {}", new Date());
    }
}
