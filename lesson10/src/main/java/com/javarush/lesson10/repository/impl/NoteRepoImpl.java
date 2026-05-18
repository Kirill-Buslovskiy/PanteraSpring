package com.javarush.lesson10.repository.impl;

import com.javarush.lesson10.model.note.Note;
import com.javarush.lesson10.repository.Repo;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

@Repository
public interface NoteRepoImpl extends Repo<Note> {
}
