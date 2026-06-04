package com.javarush.lesson16.rest.model.editor;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EditorOut {
    Long id;
    String login;
    String firstname;
    String lastname;
}
