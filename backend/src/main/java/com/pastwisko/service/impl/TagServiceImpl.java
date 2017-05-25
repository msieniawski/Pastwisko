package com.pastwisko.service.impl;

import com.pastwisko.model.Tag;
import com.pastwisko.repository.TagRepository;
import com.pastwisko.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> listAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getById(int id) {
        return tagRepository.findOne(id);
    }

    @Override
    public Tag saveOrUpdate(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void delete(int id) {
        tagRepository.delete(id);
    }
}
