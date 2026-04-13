package com.javarus.pantera.lesson01.service;

import com.javarus.pantera.lesson01.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ToString
public class UserService {

    public final UserRepository userRepository;


}
