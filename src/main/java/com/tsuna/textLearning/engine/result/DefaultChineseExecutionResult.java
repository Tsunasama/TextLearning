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
    //the alphabet of all instances
    private Alphabet alphabet;

    DefaultChineseExecutionResult(List<Topic> topics, List<Instance> instances, Alphabet alphabet) {
        super(topics, instances);
        this.alphabet = alphabet;
    }

    @Override
    public String toString() {
        return "------------主题-------------\n" +
                super.getTopicsDescription() +
                "------------文本实例------------\n" +
                super.getInstancesDescription();
    }
}
