/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : Store.java
 *  Date : 18-6-15 下午12:33
 */

package com.tsuna.textLearning.persistance;

import com.tsuna.textLearning.engine.execution.XmlChineseExecutor;
import com.tsuna.textLearning.engine.result.DefaultChineseExecutionResult;
import com.tsuna.textLearning.engine.result.element.Instance;
import com.tsuna.textLearning.engine.result.element.Topic;
import com.tsuna.textLearning.persistance.bean.Question;
import com.tsuna.textLearning.persistance.converter.QuestionUtil;
import com.tsuna.textLearning.persistance.service.QuestionService;
import com.tsuna.textLearning.persistance.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("store")
public class Store {
    @Autowired
    private TopicService topicService;

    @Autowired
    private QuestionService questionService;

    public void run() {
        XmlChineseExecutor executor = new XmlChineseExecutor();
        try {
            DefaultChineseExecutionResult result = executor.execute(5, 0.01, 0.01, "data/test/question");
            Map<Integer, com.tsuna.textLearning.persistance.bean.Topic> map = storeTopics(result.getTopics());
            storeInstances(result.getInstances(), map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<Integer, com.tsuna.textLearning.persistance.bean.Topic> storeTopics(List<Topic> topics) {
        Map<Integer, com.tsuna.textLearning.persistance.bean.Topic> tempIdToTopic = new HashMap<>();
        for (Topic topic : topics) {
            com.tsuna.textLearning.persistance.bean.Topic topicBean = new com.tsuna.textLearning.persistance.bean.Topic();
            topicBean.setDescription(topic.getDescriptionString());
            topicService.insertTopic(topicBean);
            tempIdToTopic.put(topic.getTempId(), topicBean);
        }
        return tempIdToTopic;
    }

    private void storeInstances
            (List<Instance> instances, Map<Integer, com.tsuna.textLearning.persistance.bean.Topic> map) {
        for (Instance instance : instances) {
            Question question = QuestionUtil.convertFrom(instance);
            question.setTopic(map.get(instance.getTopicTempId()));
            questionService.insertQuestion(question);
        }
    }
}
