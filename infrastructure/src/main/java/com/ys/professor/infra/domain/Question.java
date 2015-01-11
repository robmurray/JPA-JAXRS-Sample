package com.ys.professor.infra.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by rob on 1/6/15.
 */

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue
    private Long questionId;
    private String description;

    public Question() {
    }

    public Question(String description) {
        this.description = description;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
