package com.javarush.lesson11.repository;

import com.javarush.lesson11.model.story.Story;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepo extends Repo<Story> {
}
