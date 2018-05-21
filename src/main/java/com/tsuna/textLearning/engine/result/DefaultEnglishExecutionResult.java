/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : DefaultEnglishExecutionResult.java
 *  Date : 18-5-21 下午9:36
 */

package com.tsuna.textLearning.engine.result;

import cc.mallet.types.Alphabet;
import com.tsuna.textLearning.engine.result.element.Instance;
import com.tsuna.textLearning.engine.result.element.Topic;

import java.util.List;

public class DefaultEnglishExecutionResult extends ExecutionResultBase {
    //alphabet of all instances
    private Alphabet alphabet;

    DefaultEnglishExecutionResult(List<Topic> topics, List<Instance> instances, Alphabet alphabet) {
        super(topics, instances);
        this.alphabet = alphabet;
    }

    @Override
    public String toString() {
        return "------------Topics-------------\n" +
                super.getTopicsDescription() +
                "------------Instances------------\n" +
                super.getInstancesDescription();
    }
}
