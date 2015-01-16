package com.ys.professor.services;

import com.ys.professor.infra.domain.Question;
import com.ys.professor.infra.repository.RepositoryInterface;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;

import java.util.*;

/**
 * Created by rob on 1/10/15.
 */
public class QuestionServiceTest {

    private static Question question1;
    private static Question question2;
    private static Question question3;

    @Mock
    private RepositoryInterface questionRepo;

    private QuestionService questionService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        questionService = new QuestionService();
        questionService.setQuestionRepository(questionRepo);

        question1 = new Question("The original question","philosophy");
        question1.setQuestionId(new Long(1));
        question2 = new Question("The un-original question","philosophy");
        question2.setQuestionId(new Long(2));
        question3 = new Question("Why is the sky blue","science");
        question3.setQuestionId(new Long(3));

        Set<Question> questionSet=new HashSet<Question>();
        Collections.addAll(questionSet,question1, question2, question3);

        when(questionRepo.retrieveAll()).thenReturn(questionSet);
        when(questionRepo.retrieveByID(new Long(1))).thenReturn(question1);

    }

    @Test
    public void retrieveAllQuestionsTest(){
        Collection<Question>questionSet = this.questionService.retrieveAllQuestions();


        assertTrue(questionSet.size()==3);
    }

    @Test
    public void retrieveByIdTest(){

        Question theQuestion = this.questionService.retrieveQuestion(new Long(1));

        assertNotNull(theQuestion);
        assertTrue(theQuestion.getQuestionId().equals(new Long(1)));

    }
}
