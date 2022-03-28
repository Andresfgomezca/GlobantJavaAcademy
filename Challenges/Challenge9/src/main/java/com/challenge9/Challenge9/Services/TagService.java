package com.challenge9.Challenge9.Services;

import com.challenge9.Challenge9.Models.Category;
import com.challenge9.Challenge9.Models.Tag;
import com.challenge9.Challenge9.Repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    public Optional<Tag> get(Long id) {
        return tagRepository.findById(id);
    }

    public List<Tag> list() {
        return tagRepository.findAll();
    }

    public Tag create(Tag tag) {
        return tagRepository.save(tag);
    }
    public List<Tag> createAll(List<Tag> tag) {
        return tagRepository.saveAll(tag);
    }

    public void delete(Long id) {
        tagRepository.deleteById(id);
    }


}
