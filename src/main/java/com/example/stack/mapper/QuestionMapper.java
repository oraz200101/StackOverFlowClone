package com.example.stack.mapper;

import com.example.stack.dto.GetQuestionDto;
import com.example.stack.dto.GetTagDto;
import com.example.stack.dto.PostQuestionDto;
import com.example.stack.entities.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionMapper {
    GetQuestionDto fromQuestion(Question question);

    Question toQuestion(PostQuestionDto postQuestionDto);

    List<GetQuestionDto> toGetQuestionDtoList(List<Question> questions);

    Page<GetQuestionDto> getQuestionDtosPage(Pageable pageable, Page<Question> questions);

}
