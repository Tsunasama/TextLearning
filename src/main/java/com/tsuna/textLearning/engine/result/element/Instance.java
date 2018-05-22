/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : Instance.java
 *  Date : 18-5-16 下午4:35
 */

package com.tsuna.textLearning.engine.result.element;

public class Instance {
    private String path;
    private int topicTempId;

    public String getPath() {
        return path;
    }

    public int getTopicTempId() {
        return topicTempId;
    }

    public Instance(String path, int topicTempId) {
        this.path = path;
        this.topicTempId = topicTempId;
    }

    @Override
    public String toString() {
        return path + " : " + topicTempId + "\n";
    }
}
