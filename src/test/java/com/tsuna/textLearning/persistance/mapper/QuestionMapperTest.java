/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : QuestionMapperTest.java
 *  Date : 18-5-21 下午11:34
 */

package com.tsuna.textLearning.persistance.mapper;

import com.tsuna.textLearning.persistance.bean.Option;
import com.tsuna.textLearning.persistance.bean.Question;
import com.tsuna.textLearning.persistance.bean.Topic;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class QuestionMapperTest {
    private SqlSessionFactory factory;

    @Before
    public void insantiate() {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getQuestion() {
        SqlSession session = factory.openSession();
        QuestionMapper mapper = session.getMapper(QuestionMapper.class);
        Question question = mapper.getQuestion(1);
        System.out.print(question);
        session.close();
    }

    @Test
    public void insertQuestion() {
        SqlSession session = null;
        try {
            session = factory.openSession();
            QuestionMapper mapper = session.getMapper(QuestionMapper.class);
            Question question = new Question();
            question.setA("A option");
            question.setB("B option");
            question.setC("C option");
            question.setD("D option");
            question.setContent("My content");
            question.setDescription("My description");
            question.setCorrect(Option.A);
            Topic topic = new Topic();
            topic.setId(1);
            question.setTopic(topic);
            mapper.insertQuestion(question);
            session.commit();
            System.out.println(question);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}