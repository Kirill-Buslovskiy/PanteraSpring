package com.javarush.lesson15.rest.model.story;

import com.javarush.lesson15.rest.model.IdHolder;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tbl_story")
public class Story implements IdHolder {

    @Id
    Long id;

    @Column("editor_id")
    Long editorId;

    String title;
    String content;
    LocalDateTime created;
    LocalDateTime modified;

}
