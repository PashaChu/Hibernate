package com.example.hello_spring.controller;

import com.example.hello_spring.model.Tag;
import com.example.hello_spring.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> getAllTag(){
        return tagService.getAllTag();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable Long id){
        return tagService.getTagById(id);
    }

    @PostMapping
    public Tag createTag(@RequestBody Tag tag){
        return tagService.createTag(tag);
    }

    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable Long id, @RequestBody Tag tag){
        tag.setId(id);
        return tagService.updateTag(tag);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id){
        tagService.deleteTag(id);
    }
}
