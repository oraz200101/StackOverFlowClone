package com.example.stack.service;

import com.example.stack.dao.TagRepository;
import com.example.stack.dto.GetTagDto;
import com.example.stack.dto.PostTagDto;
import com.example.stack.entities.Tag;
import com.example.stack.mapper.TagMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final TagMapperImpl tagMapper;

    @Autowired(required = false)
    public TagServiceImpl(TagRepository tagRepository, TagMapperImpl tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Override
    @Transactional
    public GetTagDto save(PostTagDto postTagDto) {
        return tagMapper.toGetTagDto(tagRepository.save(tagMapper.toTag(postTagDto)));
    }

    @Override
    public List<GetTagDto> getAll() {
        return tagMapper.toGetTagDtoList(tagRepository.findAll());
    }

    @Override
    public List<Tag> sortByName() {
        return tagRepository.getAllSort();
    }

    @Override
    public Page<GetTagDto> getTagDtoPage(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 1);
        Page<Tag> tags = tagRepository.findAll(pageable);
        return tagMapper.getTagDtosPage(pageable, tags);
    }

    @Override
    public GetTagDto getById(Long id) {
        return tagMapper.toGetTagDto(tagRepository.getReferenceById(id));
    }
}
