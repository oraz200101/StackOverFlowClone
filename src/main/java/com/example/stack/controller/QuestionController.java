package com.example.stack.controller;

import com.example.stack.dto.GetQuestionDto;
import com.example.stack.dto.GetTagDto;
import com.example.stack.dto.PostQuestionDto;
import com.example.stack.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    private QuestionServiceImpl questionService;

    @Autowired
    public void setQuestionService(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @PostMapping(path = "/{tagIds}", produces = "application/json")
    public GetQuestionDto save(@RequestBody PostQuestionDto postQuestionDto, Principal principal, @PathVariable(value = "tagIds")
            List<Long> tagIds) {
        return questionService.save(postQuestionDto, principal.getName(), tagIds);
    }

    @GetMapping(path = "/all/{pageNumber}", produces = "application/json")
    public Page<GetQuestionDto> getPage(@PathVariable(value = "pageNumber") Integer pageNumber) {
        return questionService.getAll(pageNumber);
    }

}
