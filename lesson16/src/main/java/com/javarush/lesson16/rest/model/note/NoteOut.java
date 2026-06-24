package com.javarush.lesson16.rest.model.note;

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
