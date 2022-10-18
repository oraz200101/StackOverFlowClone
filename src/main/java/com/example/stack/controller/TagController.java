package com.example.stack.controller;

import com.example.stack.dto.GetTagDto;
import com.example.stack.dto.PostTagDto;
import com.example.stack.entities.Tag;
import com.example.stack.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
    private TagServiceImpl tagService;

    @Autowired
    public void setTagService(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public GetTagDto save(@RequestBody PostTagDto postTagDto) {
        return tagService.save(postTagDto);
    }

    @GetMapping(path = "/all/", produces = "application/json")
    public List<GetTagDto> getAll() {
        return tagService.getAll();
    }

    @GetMapping(path = "/all/{pageNumber}", produces = "application/json")
    public Page<GetTagDto> getTagDtoPage(@PathVariable Integer pageNumber) {
        return tagService.getTagDtoPage(pageNumber);
    }
    @GetMapping(path = "/all/sort/",produces = "application/json")
    public List<Tag> getBySort(){
        return tagService.sortByName();
    }
    @GetMapping(path = "/{id}/", produces = "application/json")
    public GetTagDto getById(@PathVariable Long id) {
        return tagService.getById(id);
    }
}
