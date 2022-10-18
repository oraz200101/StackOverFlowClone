package com.example.stack.mapper;

import com.example.stack.dto.GetQuestionDto;
import com.example.stack.dto.GetTagDto;
import com.example.stack.dto.PostQuestionDto;
import com.example.stack.entities.Question;
import com.example.stack.entities.QuestionStatus;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public GetQuestionDto fromQuestion(Question question) {
        if (question == null) {
            return null;
        }
        GetQuestionDto getQuestionDto = new GetQuestionDto();
        getQuestionDto.setName(question.getName());
        getQuestionDto.setCreated(question.getCreated());
        getQuestionDto.setDescription(question.getDescription());
        if (question.getAnswers() == null) {
            getQuestionDto.setAnswerCount(0);
        } else getQuestionDto.setAnswerCount(question.getAnswers().size());
        return getQuestionDto;
    }

    @Override
    public Question toQuestion(PostQuestionDto postQuestionDto) {
        if (postQuestionDto == null) {
            return null;
        }
        Question question = new Question();
        question.setName(postQuestionDto.getName());
        question.setDescription(postQuestionDto.getDescription());
        question.setQuestionStatus(QuestionStatus.ACTUAL);
        return question;
    }

    @Override
    public List<GetQuestionDto> toGetQuestionDtoList(List<Question> questions) {
        if (questions == null) {
            return null;
        }
        List<GetQuestionDto> list = new ArrayList<>(questions.size());
        {
            questions.forEach(question -> list.add(fromQuestion(question)));
        }
        return list;
    }

    public Page<GetQuestionDto> getQuestionDtosPage(Pageable pageable, Page<Question> questions) {
        List<GetQuestionDto> list = toGetQuestionDtoList(questions.getContent());
        return new PageImpl<>(list, pageable, questions.getTotalElements());
    }
}
