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
    private String category;

    public Question() {
    }


    public Question(String description) {
        this.description = description;
    }

    public Question(String description, String category) {
        this.description = description;
        this.category = category;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        if (!questionId.equals(question.questionId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return questionId.hashCode();
    }
}
