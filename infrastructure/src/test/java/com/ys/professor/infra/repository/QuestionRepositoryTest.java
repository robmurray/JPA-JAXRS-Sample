/*
 * Copyright 2007-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ys.professor.infra.repository;

import com.ys.professor.infra.domain.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class QuestionRepositoryTest {

    final Logger logger = LoggerFactory.getLogger(QuestionRepositoryTest.class);

    @Autowired
    protected RepositoryInterface<Question, Long> questionRepository = null;

    @Test
    public void testAddQuestion() throws SQLException {
        Question theQuestion = new Question("What is the meaning of life?", "Philosophy");

        this.questionRepository.add(theQuestion);

        assertTrue(theQuestion.getQuestionId() > 0);

    }

    @Test
    public void testRetrieveQuestion() {
        Question theQuestion = new Question("What is the question?", "Philosophy");

        this.questionRepository.add(theQuestion);
        Long questionId = theQuestion.getQuestionId();
        assertTrue(questionId > 0);

        Question retrievedQuestion = this.questionRepository.retrieveByID(questionId);

        assertEquals(theQuestion, retrievedQuestion);
    }

    @Test
    public void testDeleteQuestion() {
        Question theQuestion = new Question("why is the sky blue?", "science");

        this.questionRepository.add(theQuestion);

        assertTrue(theQuestion.getQuestionId() > 0);

        Long questionId = theQuestion.getQuestionId();
        assertTrue(questionId > 0);

        Question retrievedQuestion = this.questionRepository.retrieveByID(questionId);
        this.questionRepository.remove(retrievedQuestion);

        Question deletedQuestion = this.questionRepository.retrieveByID(questionId);
        assertTrue(deletedQuestion == null);

    }

    @Test
    public void testRetrieveAllQuestions() {
        Question theQuestion = new Question("what is your name?", "phsychology");
        this.questionRepository.add(theQuestion);
        assertTrue(theQuestion.getQuestionId() > 0);

        theQuestion = new Question("what is your obsession with your father?", "phsychology");
        this.questionRepository.add(theQuestion);
        assertTrue(theQuestion.getQuestionId() > 0);

        theQuestion = new Question("Why does it rain?", "science");
        this.questionRepository.add(theQuestion);
        assertTrue(theQuestion.getQuestionId() > 0);


        Collection<Question> list = this.questionRepository.retrieveAll();

        assertTrue(list.size() > 0);

    }

    @Test
    public void testUpdateQuestion() {
        String questionText = "what is your middle name?";
        String questionText2 = "what is your first name?";

        Question theQuestion = new Question(questionText, "inane question");
        this.questionRepository.add(theQuestion);
        Long questionId = theQuestion.getQuestionId();

        assertTrue(questionId > 0);

        Question retrievedQuestion = this.questionRepository.retrieveByID(questionId);
        assertTrue(questionText.equals(retrievedQuestion.getDescription()));

        retrievedQuestion.setDescription(questionText2);
        this.questionRepository.update(retrievedQuestion);

        Question retrievedQuestion2 = this.questionRepository.retrieveByID(questionId);
        assertTrue(questionText2.equals(retrievedQuestion2.getDescription()));


    }
}
