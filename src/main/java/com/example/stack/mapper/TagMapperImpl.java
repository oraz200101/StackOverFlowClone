package com.example.stack.mapper;

import com.example.stack.dto.GetTagDto;
import com.example.stack.dto.PostTagDto;
import com.example.stack.entities.Tag;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class TagMapperImpl implements TagMapper {
    @Override
    public GetTagDto toGetTagDto(Tag tag) {
        if (tag == null) {
            return null;
        }
        GetTagDto getTagDto = new GetTagDto();
        getTagDto.setId(tag.getId());
        getTagDto.setName(tag.getName());
        getTagDto.setDescription(tag.getDescription());
        if (tag.getQuestions() == null) {
            getTagDto.setQuestionsCount(0);
        } else getTagDto.setQuestionsCount(tag.getQuestions().size());
        return getTagDto;
    }

    @Override
    public Tag toTag(PostTagDto postTagDto) {
        if (postTagDto == null) {
            return null;
        }
        Tag tag = new Tag();
        tag.setName(postTagDto.getName());
        tag.setDescription(postTagDto.getDescription());
        return tag;
    }

    @Override
    public List<GetTagDto> toGetTagDtoList(List<Tag> tags) {
        if (tags == null) {
            return null;
        }
        List<GetTagDto> list = new ArrayList<>(tags.size());
        {
            tags.forEach(tag -> list.add(toGetTagDto(tag)));
        }

        return list;
    }

    @Override
    public Page<GetTagDto> getTagDtosPage(Pageable pageable, Page<Tag> tags) {
        List<GetTagDto> list = toGetTagDtoList(tags.getContent());
        return new PageImpl<>(list, pageable, tags.getTotalElements());
    }
}
