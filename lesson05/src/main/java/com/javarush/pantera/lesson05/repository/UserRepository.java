package com.javarush.pantera.lesson05.repository;

import com.javarush.pantera.lesson05.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Long> {

    Stream<User> readAllBy();

    @Query("select u from User u where u.id < :id and u.role = :role")
    Optional<User> findUserBy(
            @Param("id") Long idLess, //
            @Param("role") String roleEquals //
    );

    @Query("select u from User u where u.password like :password")
    User findUserByPassword(@Param("password") String password);
}
