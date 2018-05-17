/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : DefaultChineseExecutionResult.java
 *  Date : 18-5-16 下午3:53
 */

package com.tsuna.textLearning.engine.result;

import cc.mallet.types.Alphabet;
import com.tsuna.textLearning.engine.result.element.Instance;
import com.tsuna.textLearning.engine.result.element.Topic;

import java.util.List;

public class DefaultChineseExecutionResult extends ExecutionResultBase {
    private Alphabet alphabet;


    DefaultChineseExecutionResult(List<Topic> topics, List<Instance> instances, Alphabet alphabet) {
        super(topics, instances);
        this.alphabet = alphabet;
    }

    public String getTopicsDescription() {
        List<Topic> topics = super.getTopics();
        StringBuilder rtn = new StringBuilder();
        for (Topic topic : topics) {
            rtn.append(topic.toString());
        }
        return rtn.toString();
    }

    public String getInstancesDescription() {
        List<Instance> instances = super.getInstances();
        StringBuilder rtn = new StringBuilder();
        for (Instance instance : instances) {
            rtn.append(instance.toString());
        }
        return rtn.toString();
    }

    @Override
    public String toString() {
        return "------------Topics-------------\n" +
                getTopicsDescription() +
                "------------Instances------------\n" +
                getInstancesDescription();
    }
}
