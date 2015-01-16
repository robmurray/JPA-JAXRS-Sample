package com.ys.professor.app.rs;

import com.ys.professor.infra.domain.Question;
import com.ys.professor.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@Path("/question")
public class QuestionServiceBean {
    @Autowired
    private QuestionService questionService;

    //public void setQuestionService(QuestionService questionService) {
    //    this.questionService = questionService;
    //}

    @GET
    @Produces("application/json")
    public Response getQuestions() {

        Collection<Question> questions = questionService.retrieveAllQuestions();
        GenericEntity<Collection<Question>> collection = new GenericEntity<Collection<Question>>(questions){
        };

        return Response.ok(collection).build();

    }
}
