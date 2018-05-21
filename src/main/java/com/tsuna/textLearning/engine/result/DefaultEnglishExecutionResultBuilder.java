/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : DefaultEnglishExecutionResultBuilder.java
 *  Date : 18-5-21 下午9:46
 */

package com.tsuna.textLearning.engine.result;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.topics.TopicAssignment;
import cc.mallet.types.IDSorter;
import com.tsuna.textLearning.engine.result.element.Instance;
import com.tsuna.textLearning.engine.result.element.Topic;
import com.tsuna.textLearning.engine.util.CompareUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Default English result builder to build result using a {@link cc.mallet.topics.ParallelTopicModel} to estimate and
 * collect the topics and instances
 */
public class DefaultEnglishExecutionResultBuilder implements IExecutionResultBuilder<DefaultEnglishExecutionResult> {

    private ParallelTopicModel model;

    public DefaultEnglishExecutionResultBuilder(ParallelTopicModel model) {
        this.model = model;
    }

    @Override
    public DefaultEnglishExecutionResult build() {
        return new DefaultEnglishExecutionResult(
                collectTopics(),
                collectInstances(),
                model.alphabet
        );
    }

    /**
     * Collect topics in the model to make it a regular set
     *
     * @return topic list
     */
    private List<Topic> collectTopics() {
        int topicSize = model.getNumTopics();
        List<Topic> topics = new ArrayList<>();
        ArrayList<TreeSet<IDSorter>> topicSortedWords = model.getSortedWords();
        for (int i = 0; i < topicSize; i++) {
            Topic topic = new Topic();
            List<String> description = new ArrayList<>();
            Iterator<IDSorter> iterator = topicSortedWords.get(i).iterator();
            int count = 0;
            while (iterator.hasNext() && count < 10) {
                IDSorter idSorter = iterator.next();
                description.add((String) model.alphabet.lookupObject(idSorter.getID()));
                count++;
            }
            topic.setTempId(i);
            topic.setDescription(description);
            topics.add(topic);
        }

        return topics;
    }

    /**
     * Collect instances in the model and make it a regular set
     *
     * @return instance list
     */
    private List<Instance> collectInstances() {
        int instanceSize = model.getData().size();
        List<Instance> instances = new ArrayList<>();
        for (int i = 0; i < instanceSize; i++) {
            TopicAssignment topicAssignment = model.getData().get(i);
            cc.mallet.types.Instance instance = topicAssignment.instance;
            Instance instance1 = new Instance(instance.getName().toString(),
                    CompareUtil.getMaxIndex(model.getTopicProbabilities(i)));
            instances.add(instance1);
        }
        return instances;
    }
}
