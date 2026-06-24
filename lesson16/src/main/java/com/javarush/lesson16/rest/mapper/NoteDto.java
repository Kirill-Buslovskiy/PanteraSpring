package com.javarush.lesson16.rest.mapper;

import com.javarush.lesson16.rest.model.note.Note;
import com.javarush.lesson16.rest.model.note.NoteIn;
import com.javarush.lesson16.rest.model.note.NoteOut;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface NoteDto {

    NoteOut out(Note entity);

    Note in(NoteIn inputDto);
}
