package com.javarush.lesson09.model.editor;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Editor {
    Long id;
    String login;
    String password;
    String firstname;
    String lastname;


}
