package com.javarush.pantera.lesson06.service;

import com.javarush.pantera.lesson06.config.AppConfig;
import com.javarush.pantera.lesson06.entity.Quest;
import com.javarush.pantera.lesson06.entity.User;
import com.javarush.pantera.lesson06.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@ToString
public class UserService {
    private AppConfig appConfig;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getById(Long id) {
        System.out.println(appConfig);
        User user = userRepository.findById(id).orElseThrow();
        System.out.println(user);
        List<Quest> quests = user.getQuests();
        quests.forEach(System.out::println);
        System.out.println("+".repeat(50));
        return user;
    }

    @Transactional(readOnly = true)
    public User getByUsername(String login) {
        return userRepository.findByLogin(login).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<User> findAllAdminWithName(String login) {
        Stream<User> adm = userRepository.findUserBy(login, "adm");
        return adm.toList();
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
        throw new RuntimeException("test");
    }

    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
