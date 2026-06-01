package com.javarush.lesson15.rest.model.note;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NoteOut {
    Long id;
    Long storyId;
    String content;
}
