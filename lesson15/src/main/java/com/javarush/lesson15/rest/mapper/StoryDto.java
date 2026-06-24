package com.javarush.lesson15.rest.mapper;

import com.javarush.lesson15.rest.model.story.Story;
import com.javarush.lesson15.rest.model.story.StoryIn;
import com.javarush.lesson15.rest.model.story.StoryOut;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface StoryDto {

    StoryOut out(Story entity);

    Story in(StoryIn inputDto);

}
