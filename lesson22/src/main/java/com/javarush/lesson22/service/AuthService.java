package com.javarush.lesson22.service;

import com.javarush.lesson22.repository.Repo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService {

    private final Repo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var inDb = repo.findByLogin(username);
        return User.withUsername(inDb.getLogin())
                .password(inDb.getPassword())
                .roles(inDb.getRole().getRole())
                .build();
    }
}
