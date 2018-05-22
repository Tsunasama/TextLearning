/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : TopicMapper.java
 *  Date : 18-5-21 下午10:49
 */

package com.tsuna.textLearning.persistance.mapper;

import com.tsuna.textLearning.persistance.bean.Topic;

public interface TopicMapper {
    Topic getTopic(int id);

    void insertTopic(Topic topic);
}
