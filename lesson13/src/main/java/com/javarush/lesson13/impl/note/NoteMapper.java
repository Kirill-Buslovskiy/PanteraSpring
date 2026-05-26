package com.javarush.lesson13.impl.note;

import com.javarush.lesson13.impl.note.model.Note;
import com.javarush.lesson13.impl.note.model.NoteRequestTo;
import com.javarush.lesson13.impl.note.model.NoteResponseTo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface NoteMapper {
    NoteResponseTo getResponseTo(Note note);

    List<NoteResponseTo> getListResponseTo(Iterable<Note> notes);

    Note getEntity(NoteRequestTo noteRequestTo);

    List<Note> getListEntity(Iterable<NoteRequestTo> noteRequestTos);

    Note notNullCopy(Note note);
}