/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : StoreTest.java
 *  Date : 18-6-15 下午12:34
 */

package com.tsuna.textLearning.persistance;

import com.tsuna.textLearning.persistance.service.QuestionService;
import com.tsuna.textLearning.persistance.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TopicService.class, QuestionService.class, Store.class})
@ActiveProfiles("prod")
public class StoreTest {

    @Autowired
    Store store;
    @Autowired
    TopicService topicService;
    @Autowired
    QuestionService questionService;

    @Test
    public void run() {
        store.run();
    }
}