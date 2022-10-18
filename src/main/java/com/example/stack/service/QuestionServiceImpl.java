package com.example.stack.service;

import com.example.stack.dao.QuestionRepository;
import com.example.stack.dao.TagRepository;
import com.example.stack.dao.UserRepository;
import com.example.stack.dto.GetQuestionDto;
import com.example.stack.dto.GetTagDto;
import com.example.stack.dto.PostQuestionDto;
import com.example.stack.entities.Question;
import com.example.stack.entities.Tag;
import com.example.stack.entities.User;
import com.example.stack.mapper.QuestionMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final QuestionMapperImpl questionMapper;

    @Autowired(required = false)
    public QuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository, TagRepository tagRepository, QuestionMapperImpl questionMapper) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.questionMapper = questionMapper;
    }

    @Override
    public GetQuestionDto getById(Long id) {
        return null;
    }

    @Override
    public GetQuestionDto save(PostQuestionDto postQuestionDto, String username, List<Long> tagIds) {
        User savedUser = userRepository.findByName(username);
        if (savedUser == null) {
            System.out.println("You are not authorize");
        }
        List<Tag> tags = getCollectRefTagsById(tagIds);
        Question question = questionMapper.toQuestion(postQuestionDto);
        question.setUser(savedUser);
        question.setTags(tags);
        questionRepository.save(question);
        return questionMapper.fromQuestion(question);
    }

    private List<Tag> getCollectRefTagsById(List<Long> tagIds) {
        return tagIds.stream()
                .map(tagRepository::getOne)
                .collect(Collectors.toList());
    }

    @Override
    public Page<GetQuestionDto> getAll(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 15);
        Page<Question> questions = questionRepository.findAll(pageable);
        return questionMapper.getQuestionDtosPage(pageable, questions);
    }
}
