package com.javarush.lesson08.model.story;

import com.javarush.lesson08.repository.Repo;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Story {

    Long id;
    Long editorId;
    String title;
    String content;
    LocalDateTime created;
    LocalDateTime modified;


}
