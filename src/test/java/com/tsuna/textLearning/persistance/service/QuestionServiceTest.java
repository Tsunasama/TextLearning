/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : QuestionServiceTest.java
 *  Date : 18-6-15 上午11:08
 */

package com.tsuna.textLearning.persistance.service;

import com.tsuna.textLearning.persistance.bean.Question;
import com.tsuna.textLearning.persistance.bean.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {QuestionService.class})
@ActiveProfiles("prod")
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Test
    public void testGetQuestion() {
        Question question = questionService.getQuestion(1);
        System.out.println(question);
    }

    @Test
    public void testGetAllQuestion() {
        List<Question> questionList = questionService.getAllQuestions();
        for (Question question : questionList) {
            System.out.println(question + "\n");
        }
    }

    @Test
    public void testInsertQuestion() {
        Question question = new Question();
        question.setA("test A");
        question.setB("test B");
        question.setC("test C");
        question.setD("test D");
        question.setContent("test content");
        question.setDescription("test description");
        Topic topic = new Topic();
        topic.setId(1);
        question.setTopic(topic);
        questionService.insertQuestion(question);
    }

    @Test
    public void testUpdateQuestion() {
        Question question = new Question();
        question.setId(21);
        question.setA("my test A");
        question.setB("my test B");
        question.setC("my test C");
        question.setD("my test D");
        question.setContent("my test content");
        question.setDescription("my test description");
        Topic topic = new Topic();
        topic.setId(1);
        question.setTopic(topic);
        questionService.updateQuestion(question);
    }

    @Test
    public void testDeleteQuestion() {
        int i = questionService.deleteQuestion(22);
        System.out.println(i);
    }
}