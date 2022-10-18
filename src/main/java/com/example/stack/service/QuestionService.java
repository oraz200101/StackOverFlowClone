package com.example.stack.service;

import com.example.stack.dto.GetQuestionDto;
import com.example.stack.dto.GetTagDto;
import com.example.stack.dto.PostQuestionDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuestionService {
    GetQuestionDto getById(Long id);

    GetQuestionDto save(PostQuestionDto postQuestionDto, String username, List<Long> tagIds);

    Page<GetQuestionDto> getAll(Integer pageNumber);


}
