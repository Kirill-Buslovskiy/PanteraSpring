package com.javarush.pantera.lesson05.service;

import com.javarush.pantera.lesson05.entity.User;
import com.javarush.pantera.lesson05.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public List<User> findAll() {
        return userRepository
                .readAllBy()
                .map(udb -> udb) //for dto mapping
                .toList();

    }

    public User findUserBy(Long idLessThen, String roleEquals) {
        return userRepository
                .findUserBy(idLessThen, roleEquals)
                //.map(udb -> udb) //for dto
                .orElse(null);
    }

    public User findUserByPassword(String password) {
        return userRepository.findUserByPassword(password);
    }
}
