package com.javarush.lesson10.repository.impl;

import com.javarush.lesson10.model.tag.Tag;
import com.javarush.lesson10.repository.Repo;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends Repo<Tag> {
}
