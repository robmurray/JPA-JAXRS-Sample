package com.ys.professor.services;

import com.ys.professor.infra.repository.RepositoryInterface;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.*;
import org.mockito.MockitoAnnotations;

/**
 * Created by rob on 1/10/15.
 */
public class QuestionServiceTest {


    @Mock
    private RepositoryInterface questionRepo;

    private QuestionService questionService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        questionService = new QuestionService();
        questionService.setQuestionRepo(questionRepo);
    }

    @Test
    public void retrieveAllQuestionsTest(){

        assertTrue(true);
    }


}
