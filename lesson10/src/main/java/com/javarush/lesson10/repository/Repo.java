package com.javarush.lesson10.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.Optional;
import java.util.stream.Stream;

@NoRepositoryBean
public interface Repo<T> extends ListCrudRepository<T, Long> {

    default Stream<T> getAll() {
        return findAll().stream();
    }

    default Optional<T> get(Long id) {
        return findById(id);
    }

    default Optional<T> create(T input) {
        return Optional.of(save(input));
    }

    default Optional<T> update(T input) {
        return Optional.of(save(input));
    }

    default boolean delete(Long id) {
        if (existsById(id)) {
            deleteById(id);
            return true;
        }
        return false;
    }
}