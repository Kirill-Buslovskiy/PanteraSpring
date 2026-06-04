package com.javarush.lesson16.rest.repository;

import com.javarush.lesson16.rest.model.story.Story;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepo extends Repo<Story> {
}
