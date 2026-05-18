package com.javarush.lesson09.mapper;

import com.javarush.lesson09.model.note.Note;
import com.javarush.lesson09.model.note.NoteIn;
import com.javarush.lesson09.model.note.NoteOut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteDto {
    NoteOut out(Note entity);

    Note in(NoteIn inputDto);
}
