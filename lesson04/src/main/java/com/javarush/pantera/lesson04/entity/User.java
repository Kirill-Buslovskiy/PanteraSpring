package com.javarush.pantera.lesson04.entity;

import com.javarush.pantera.lesson04.validator.annotation.Max;
import com.javarush.pantera.lesson04.validator.annotation.Min;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;

    @Max(9)
    @Min(4)
    private String name;

    private String email;

    @Min(8)
    private String password;

}
