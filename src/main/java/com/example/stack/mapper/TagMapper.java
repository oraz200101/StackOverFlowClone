package com.example.stack.mapper;

import com.example.stack.dto.GetTagDto;
import com.example.stack.dto.PostTagDto;
import com.example.stack.entities.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagMapper {
    GetTagDto toGetTagDto(Tag tag);

    Tag toTag(PostTagDto postTagDto);

    List<GetTagDto> toGetTagDtoList(List<Tag> tags);

    Page<GetTagDto> getTagDtosPage(Pageable pageable, Page<Tag> tags);

}
