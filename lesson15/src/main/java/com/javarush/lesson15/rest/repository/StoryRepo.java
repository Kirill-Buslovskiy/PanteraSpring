package com.javarush.lesson15.rest.repository;

import com.javarush.lesson15.rest.model.story.Story;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepo extends Repo<Story> {
}
