package com.javarush.lesson10.mapper;

import com.javarush.lesson10.model.editor.Editor;
import com.javarush.lesson10.model.editor.EditorIn;
import com.javarush.lesson10.model.editor.EditorOut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EditorDto {
    EditorOut out(Editor entity);

    Editor in(EditorIn inputDto);
}
