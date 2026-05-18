package com.javarush.lesson10.repository.impl;

import com.javarush.lesson10.model.editor.Editor;
import com.javarush.lesson10.repository.Repo;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepo extends Repo<Editor> {
}
