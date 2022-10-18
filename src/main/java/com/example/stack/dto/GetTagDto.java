package com.example.stack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTagDto {
    private Long id;
    private String name;
    private String description;
    private long questionsCount;

}

