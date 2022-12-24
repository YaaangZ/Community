package com.yang.Cache;

import com.yang.Dto.TagDto;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDto> get() {
        List<TagDto> tagDto = new ArrayList<>();
        TagDto program = new TagDto();
        program.setCategoryName("development language");
        program.setTags(Arrays.asList("javascript", "php", "css", "html", "html5",
                "java", "node.js", "python", "c++", "c", "golang", "objective-c",
                "typescript", "shell", "swift", "c#", "sass", "ruby", "bash", "less",
                "asp.net", "lua", "scala", "coffeescript", "actionscript", "rust", "erlang", "perl"));
        tagDto.add(program);

        TagDto frameworks = new TagDto();
        frameworks.setCategoryName("frameworks");
        frameworks.setTags(Arrays.asList("laravel", "spring", "express", "django", "flask", "yii", "ruby-on-rails", "tornado", "koa", "struts"));
        tagDto.add(frameworks);

        TagDto server = new TagDto();
        server.setCategoryName("server");
        server.setTags(Arrays.asList("linux", "nginx", "docker", "apache", "ubuntu", "centos", "tomcat", "unix", "hadoop", "windows-server"));
        tagDto.add(server);

        TagDto db = new TagDto();
        db.setCategoryName("database");
        db.setTags(Arrays.asList("mysql", "redis", "mongodb", "sql", "oracle", "nosql memcached", "sqlserver", "postgresql", "sqlite"));
        tagDto.add(db);

        TagDto tool = new TagDto();
        tool.setCategoryName("development tools");
        tool.setTags(Arrays.asList("git", "github", "visual-studio-code", "vim", "sublime-text", "xcode intellij-idea", "eclipse", "maven", "ide", "svn", "visual-studio", "atom emacs", "textmate", "hg"));
        tagDto.add(tool);
        return tagDto;
    }

    public static String filterInvalid(String tags) {
        String[] split = StringUtils.split(tags, ",");
        List<TagDto> tagDTOS = get();
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> StringUtils.isBlank(t) || !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}
