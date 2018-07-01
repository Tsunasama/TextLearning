/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : TopicServiceTest.java
 *  Date : 18-6-15 下午12:29
 */

package com.tsuna.textLearning.persistance.service;

import com.tsuna.textLearning.persistance.bean.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TopicService.class})
@ActiveProfiles("prod")
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void getTopic() {
        Topic topic = topicService.getTopic(1);
        System.out.println(topic);
    }

    @Test
    public void insertTopic() {
        Topic topic = new Topic();
        topic.setId(23);
        topic.setDescription("my topic");
        topicService.insertTopic(topic);
    }
}