package com.example.stack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetQuestionDto {
    private int id;
    private String name;
    private String description;
    private LocalDateTime created;
    private int answerCount;
    private List<GetTagDto> getTagDtos;
    private List<GetAnswerDto> getAnswerDtos;
}
