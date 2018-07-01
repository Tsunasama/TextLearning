/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : QuestionResource.java
 *  Date : 18-6-10 下午4:27
 */

package com.tsuna.textLearning.rest.resource;

import com.tsuna.textLearning.persistance.bean.Question;
import com.tsuna.textLearning.persistance.bean.Questions;
import com.tsuna.textLearning.persistance.bean.Topic;
import com.tsuna.textLearning.persistance.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("questions")
public class QuestionResource {

    @Autowired
    QuestionService questionService;


    @GET
    @Path("/mytopic")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Topic getMyTopic() {
        Topic topic = new Topic();
        topic.setDescription("my description");
        topic.setId(1);
        return topic;
    }

    @GET
    @Path("/myquestions")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Questions getMyQuestions() {
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questions = new ArrayList<>();
        question1.setDescription("question1");
        question2.setDescription("question2");
        questions.add(question1);
        questions.add(question2);
        Questions questionList = new Questions(questions);
        return questionList;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Questions getQuestions() {
        List<Question> questionList = questionService.getAllQuestions();
        Questions questions = new Questions(questionList);
        return questions;
    }

    @Path("{questionId:[0-9]*}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Question getBookByPath(@PathParam("questionId") final int questionId) {
        Question question = questionService.getQuestion(questionId);
        return question;
    }

    @Path("/question")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Question getBookByQuery(@QueryParam("id") final int questionId) {
        Question question = questionService.getQuestion(questionId);
        return question;
    }

    @Path("{questionId:[0-9]*}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Question updateQuestion(@PathParam("questionId") final int questionId, final Question question) {
        if (question == null) {
            return null;
        }
        questionService.updateQuestion(question);
        return question;
    }

    @Path("/{questionId:[0-9]*}")
    @Produces({MediaType.TEXT_PLAIN})
    @DELETE
    public String deleteQuestion(@PathParam("questionId") final int questionId) {
        int i = questionService.deleteQuestion(questionId);
        if (i == 0)
            return "delete failed,please check question id.";
        if (i == 1)
            return "delete question id=" + questionId;
        else return "cannot delete question";
    }
}
