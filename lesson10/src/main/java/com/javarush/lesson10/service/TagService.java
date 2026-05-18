package com.javarush.lesson10.service;

import com.javarush.lesson10.mapper.TagDto;
import com.javarush.lesson10.model.tag.TagIn;
import com.javarush.lesson10.model.tag.TagOut;
import com.javarush.lesson10.repository.impl.TagRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {

    public final TagRepo repoImpl;
    public final TagDto mapper;

    public List<TagOut> getAll() {
        return repoImpl
                .getAll()
                .map(mapper::out)
                .toList();
    }

    public TagOut get(Long id) {
        return repoImpl
                .get(id)
                .map(mapper::out)
                .orElseThrow();
    }

    public TagOut create(TagIn input) {
        return repoImpl
                .create(mapper.in(input))
                .map(mapper::out)
                .orElseThrow();
    }

    public TagOut update(TagIn input) {
        return repoImpl
                .update(mapper.in(input))
                .map(mapper::out)
                .orElseThrow();
    }

    public boolean delete(Long id) {
        return repoImpl.delete(id);
    }
}
