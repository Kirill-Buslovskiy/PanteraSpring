package com.javarush.lesson09.model.note;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Note {

    Long id;
    Long storyId;
    String content;


}
