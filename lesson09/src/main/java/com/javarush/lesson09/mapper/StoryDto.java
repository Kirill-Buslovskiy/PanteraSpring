package com.javarush.lesson09.mapper;

import com.javarush.lesson09.model.story.Story;
import com.javarush.lesson09.model.story.StoryIn;
import com.javarush.lesson09.model.story.StoryOut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoryDto {
    StoryOut out(Story entity);

    Story in(StoryIn inputDto);
}
