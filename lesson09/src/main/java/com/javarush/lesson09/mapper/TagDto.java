package com.javarush.lesson09.mapper;

import com.javarush.lesson09.model.tag.Tag;
import com.javarush.lesson09.model.tag.TagIn;
import com.javarush.lesson09.model.tag.TagOut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagDto {
    TagOut out(Tag entity);

    Tag in(TagIn inputDto);
}
