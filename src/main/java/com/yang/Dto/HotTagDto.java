package com.yang.Dto;

import lombok.Data;

@Data
public class HotTagDto implements Comparable {
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((HotTagDto) o).getPriority();
    }
}
