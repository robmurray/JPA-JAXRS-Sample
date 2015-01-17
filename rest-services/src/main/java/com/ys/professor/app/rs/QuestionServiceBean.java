package com.ys.professor.app.rs;

import com.ys.professor.infra.domain.Question;
import com.ys.professor.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@Path("/question")
public class QuestionServiceBean {

    @Context
    private UriInfo uriInfo;

    @Autowired
    private QuestionService questionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuestions() {
        Collection<Question> questions = questionService.retrieveAllQuestions();
        GenericEntity<Collection<Question>> collection = new GenericEntity<Collection<Question>>(questions){
        };
        return Response.ok(collection).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuestion(@PathParam("id") Long id) {
        Question question = questionService.retrieveQuestion(id);
        return Response.ok(question).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createQuestion(Question question){
        //curl -i -H "Content-Type:application/json" -H "Accept: application/json" -X POST -d '{"description":"what is your name?","questionId":1}' http://localhost:9090/prof-rs/rs/question
        return Response.ok().header ("Location", this.uriInfo.getAbsolutePathBuilder().path("1")).build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateQuestion(Question question){
        //curl -i -H "Content-Type:application/json" -H "Accept: application/json" -X PUT -d '{"description":"what is your name?","questionId":1}' http://localhost:9090/prof-rs/rs/question
        return Response.ok().build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteQuestion(@PathParam("id") Long id){
        //curl -i -X DELETE http://localhost:9090/prof-rs/rs/question/1

        return Response.ok().build();
    }

}
