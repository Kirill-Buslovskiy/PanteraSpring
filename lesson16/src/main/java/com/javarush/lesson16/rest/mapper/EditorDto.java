package com.javarush.lesson16.rest.mapper;

import com.javarush.lesson16.rest.model.editor.Editor;
import com.javarush.lesson16.rest.model.editor.EditorIn;
import com.javarush.lesson16.rest.model.editor.EditorOut;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EditorDto {
    EditorOut out(Editor entity);

    Editor in(EditorIn inputDto);
}
