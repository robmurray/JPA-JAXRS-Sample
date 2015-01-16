package com.ys.professor.services;

import com.ys.professor.infra.domain.Question;
import com.ys.professor.infra.repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by rob on 1/10/15.
 */
@Component
public class QuestionService {

    @Autowired
    @Qualifier("questionRepository")
    private RepositoryInterface<Question,Long> questionRepository;

    public QuestionService() {
    }


    public void setQuestionRepository(RepositoryInterface<Question, Long> questionRepository) {
        this.questionRepository = questionRepository;
    }


    public Collection<Question> retrieveAllQuestions(){

        return questionRepository.retrieveAll();

    }

    public Question retrieveQuestion(Long questionId){

        return questionRepository.retrieveByID(questionId);
    }
}
