package com.challenge9.Challenge9.Controllers;

import com.challenge9.Challenge9.Models.Tag;
import com.challenge9.Challenge9.Services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public ResponseEntity<Tag> list() {
        List<Tag> tags = tagService.list();
        return new ResponseEntity(tags, HttpStatus.OK);
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tag> tagById(@PathVariable(value = "id") Long id) {
        Optional<Tag> tag = tagService.get(id);
        if(tag.isPresent()){
            return new ResponseEntity(tag, HttpStatus.OK);
        }
        return new ResponseEntity("", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public ResponseEntity<Tag> create(@RequestBody Tag tag) {
        Tag tagCreated = tagService.create(tag);
        return new ResponseEntity(tagCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.DELETE)
    public  void delete(@PathVariable("id") Long Id) {
        tagService.delete(Id);
    }
}
