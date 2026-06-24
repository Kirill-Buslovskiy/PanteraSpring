package com.javarush.lesson15.rest.repository;

import com.javarush.lesson15.rest.model.IdHolder;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@NoRepositoryBean
public interface Repo<T extends IdHolder> extends ReactiveCrudRepository<T, Long> {

    default Flux<T> getAll() {
        return findAll();
    }

    default Mono<T> get(Long id) {
        return findById(id);
    }


    default Mono<T> create(T input) {
        Long id = input.getId();
        if (id!=null) {
            throw new RuntimeException("Id not null, need null");
        }
        return save(input);
    }


    default Mono<T> update(T input) {
        return existsById(input.getId())
                .flatMap(exists -> {
                    if (exists) {
                        return save(input);
                    } else {
                        return Mono.empty();
                    }
                });
    }

    default Mono<Void> delete(Long id) {
        return existsById(id)
                .flatMap(exists -> {
                    if (exists) {
                        return deleteById(id);
                    } else {
                        throw new NoSuchElementException("id not found");
                    }
                });
    }
}