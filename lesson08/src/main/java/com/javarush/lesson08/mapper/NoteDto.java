package com.javarush.lesson08.mapper;

import com.javarush.lesson08.model.note.Note;
import com.javarush.lesson08.model.note.NoteIn;
import com.javarush.lesson08.model.note.NoteOut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteDto {
    NoteOut out(Note entity);

    Note in(NoteIn inputDto);
}
