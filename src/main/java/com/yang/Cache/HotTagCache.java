package com.yang.Cache;

import com.yang.Dto.HotTagDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
public class HotTagCache {
    private Map<String, Integer> tags = new HashMap<>();
    private List<String> list = new ArrayList<>();

    public void updateTags(Map<String, Integer> tags) {
        int max = 10;
        PriorityQueue<HotTagDto> priorityQueue = new PriorityQueue<>(max);
        tags.forEach((name, priority) -> {
            HotTagDto hotTagDto = new HotTagDto();
            hotTagDto.setName(name);
            hotTagDto.setPriority(priority);
            if (priorityQueue.size() < 10) {
                priorityQueue.add(hotTagDto);
            } else {
                HotTagDto lowest = priorityQueue.peek();
                if (hotTagDto.compareTo(lowest) > 0) {
                    priorityQueue.poll();
                    priorityQueue.add(hotTagDto);
                }
            }
        });
        List<String> sortedTags = new ArrayList<>();
        HotTagDto poll = priorityQueue.poll();
        while (poll != null) {
            sortedTags.add(0, poll.getName());
            poll = priorityQueue.poll();
        }
        list = sortedTags;
    }
}
