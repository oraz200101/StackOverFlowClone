package com.example.stack.service;

import com.example.stack.dto.GetTagDto;
import com.example.stack.dto.PostTagDto;
import com.example.stack.entities.Tag;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TagService {
    GetTagDto save(PostTagDto postTagDto);
    List<Tag>sortByName();
    List<GetTagDto> getAll();

    Page<GetTagDto> getTagDtoPage(Integer pageNumber);

    GetTagDto getById(Long id);
}
