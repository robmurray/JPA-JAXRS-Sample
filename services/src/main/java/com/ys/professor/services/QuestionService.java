package com.ys.professor.services;

import com.ys.professor.infra.domain.Question;
import com.ys.professor.infra.repository.RepositoryInterface;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by rob on 1/10/15.
 */
public class QuestionService {

    private RepositoryInterface<Question,Long> questionRepo;

    public QuestionService() {
    }


    public void setQuestionRepo(RepositoryInterface<Question, Long> questionRepo) {
        this.questionRepo = questionRepo;
    }


    public Collection<Question> retrieveAllQuestions(){

        return questionRepo.retrieveAll();

    }

    public Question retrieveQuestion(Long questionId){

        return questionRepo.retrieveByID(questionId);
    }
}
