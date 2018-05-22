/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : TopicMapperTest.java
 *  Date : 18-5-22 上午7:38
 */

package com.tsuna.textLearning.persistance.mapper;

import com.tsuna.textLearning.persistance.bean.Topic;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TopicMapperTest {

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
    public void getTopic() {
        SqlSession session = factory.openSession();
        TopicMapper mapper = session.getMapper(TopicMapper.class);
        Topic topic = mapper.getTopic(1);
        System.out.print(topic);
        session.close();
    }

    @Test
    public void insertTopic() {
        SqlSession session = null;
        try {
            session = factory.openSession();
            TopicMapper mapper = session.getMapper(TopicMapper.class);
            Topic topic = new Topic();
            topic.setDescription("My description");
            mapper.insertTopic(topic);
            session.commit();
            System.out.println(topic);
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