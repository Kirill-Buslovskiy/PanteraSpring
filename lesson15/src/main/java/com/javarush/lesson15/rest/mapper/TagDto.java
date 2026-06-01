package com.javarush.lesson15.rest.mapper;

import com.javarush.lesson15.rest.model.tag.Tag;
import com.javarush.lesson15.rest.model.tag.TagIn;
import com.javarush.lesson15.rest.model.tag.TagOut;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TagDto {
    TagOut out(Tag entity);

    Tag in(TagIn inputDto);
}
