package com.javarush.lesson11.repository;

import com.javarush.lesson11.model.note.Note;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends Repo<Note> {
}
