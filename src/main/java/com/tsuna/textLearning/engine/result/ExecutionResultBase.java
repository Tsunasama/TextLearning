/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : ExecutionResultBase.java
 *  Date : 18-5-17 上午9:02
 */

package com.tsuna.textLearning.engine.result;

import com.sun.istack.internal.NotNull;
import com.tsuna.textLearning.engine.result.element.Instance;
import com.tsuna.textLearning.engine.result.element.Topic;

import java.util.List;

/**
 * An execution result
 */
public abstract class ExecutionResultBase {
    private List<Topic> topics;
    private List<Instance> instances;

    ExecutionResultBase(@NotNull List<Topic> topics, @NotNull List<Instance> instances) {
        this.topics = topics;
        this.instances = instances;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public List<Instance> getInstances() {
        return instances;
    }

    public String getTopicsDescription() {
        List<Topic> topics = this.getTopics();
        StringBuilder rtn = new StringBuilder();
        for (Topic topic : topics) {
            rtn.append(topic.toString());
        }
        return rtn.toString();
    }

    public String getInstancesDescription() {
        List<Instance> instances = this.getInstances();
        StringBuilder rtn = new StringBuilder();
        for (Instance instance : instances) {
            rtn.append(instance.toString());
        }
        return rtn.toString();
    }
}
