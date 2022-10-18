package com.example.stack.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "questions")
public class Question {
    private static final String SEQ_NAME = "question_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    @CreationTimestamp
    private LocalDateTime created;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(mappedBy = "questions")
    private List<Tag> tags;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    @Enumerated(EnumType.STRING)
    private QuestionStatus questionStatus;


}

